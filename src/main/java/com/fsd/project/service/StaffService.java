package com.fsd.project.service;

import com.fsd.project.dto.StaffDTO;
import com.fsd.project.exception.ResourceNotFoundException;
import com.fsd.project.model.Department;
import com.fsd.project.model.Staff;
import com.fsd.project.repo.DepartmentRepository;
import com.fsd.project.repo.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class StaffService {

    @Autowired private StaffRepository staffRepository;
    @Autowired private DepartmentRepository departmentRepository;

    public List<StaffDTO> getAllStaff() {
        return staffRepository.findAll().stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    public StaffDTO getStaffById(Long id) {
        return staffRepository.findById(id)
                .map(this::mapEntityToDto)
                .orElseThrow(() -> new ResourceNotFoundException("Staff not found with id: " + id));
    }

    @Transactional
    public StaffDTO createStaff(StaffDTO dto) {
        Staff s = new Staff();
        s.setName(dto.getName());
        s.setRole(dto.getRole());
        s.setPhone(dto.getPhone());
        s.setAddress(dto.getAddress());
        s.setEmail(dto.getEmail()); 

        Department dept = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + dto.getDepartmentId()));
        s.setDepartment(dept);

        Staff savedStaff = staffRepository.save(s);
        return mapEntityToDto(savedStaff);
    }

    @Transactional
    public StaffDTO updateStaff(Long id, StaffDTO dto) {
        Staff s = staffRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Staff not found with id: " + id));
        
        s.setName(dto.getName());
        s.setRole(dto.getRole());
        s.setPhone(dto.getPhone());
        s.setAddress(dto.getAddress());
        s.setEmail(dto.getEmail()); 

        if (dto.getDepartmentId() != null) {
            Department dept = departmentRepository.findById(dto.getDepartmentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + dto.getDepartmentId()));
            s.setDepartment(dept);
        }
        Staff updatedStaff = staffRepository.save(s);
        return mapEntityToDto(updatedStaff);
    }

    @Transactional
    public void deleteStaff(Long id) {
        if (!staffRepository.existsById(id)) {
            throw new ResourceNotFoundException("Staff not found with id: " + id);
        }
        staffRepository.deleteById(id);
    }

    private StaffDTO mapEntityToDto(Staff s) {
        StaffDTO dto = new StaffDTO();
        dto.setId(s.getId());
        dto.setName(s.getName());
        dto.setRole(s.getRole());
        dto.setPhone(s.getPhone());
        dto.setAddress(s.getAddress());
        dto.setEmail(s.getEmail()); 
        
        if (s.getDepartment() != null) {
            dto.setDepartmentName(s.getDepartment().getName());
        }
        return dto;
    }
}