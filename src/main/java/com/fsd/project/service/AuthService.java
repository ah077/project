package com.fsd.project.service;

import com.fsd.project.dto.AuthenticationRequest;
import com.fsd.project.dto.AuthenticationResponse;
import com.fsd.project.dto.RegisterRequest;
import com.fsd.project.model.Staff;
import com.fsd.project.model.Student;
import com.fsd.project.model.User;
import com.fsd.project.repo.StaffRepository;
import com.fsd.project.repo.StudentRepository;
import com.fsd.project.repo.UserRepository;
import com.fsd.project.security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final StaffRepository staffRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository, StudentRepository studentRepository, StaffRepository staffRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.staffRepository = staffRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @Transactional
    public AuthenticationResponse register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalStateException("Email already in use");
        }

        User.UserRole role = User.UserRole.valueOf("ROLE_" + request.getRole().toUpperCase());

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(role);
        
        if (role == User.UserRole.ROLE_STUDENT) {
            Student studentProfile = new Student();
            studentProfile.setName(request.getName());
            studentProfile.setEmail(request.getEmail());
            studentProfile.setRgNo(request.getRgNo());
            studentProfile.setUser(user);
            studentRepository.save(studentProfile);
        } else if (role == User.UserRole.ROLE_STAFF) {
            Staff staffProfile = new Staff();
            staffProfile.setName(request.getName());
            staffProfile.setEmail(request.getEmail());
            staffProfile.setRole(request.getStaffRole()); // ✅ FIX: Set the staff's role from the request
            staffProfile.setUser(user);
            staffRepository.save(staffProfile);
        } else {
            throw new IllegalArgumentException("Invalid user role specified");
        }

        String jwtToken = jwtUtil.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        User user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new IllegalStateException("User not found after successful authentication"));
        
        String jwtToken = jwtUtil.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }
}