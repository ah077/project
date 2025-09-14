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
    public Staff createStaff(StaffDTO dto) {
        Staff s = new Staff();
        s.setName(dto.getName());
        s.setRole(dto.getRole());
        s.setPhone(dto.getPhone());
        s.setAddress(dto.getAddress());

        Department dept = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + dto.getDepartmentId()));
        s.setDepartment(dept);

        return staffRepository.save(s);
    }

    private StaffDTO mapEntityToDto(Staff s) {
        StaffDTO dto = new StaffDTO();
        dto.setId(s.getId());
        dto.setName(s.getName());
        dto.setRole(s.getRole());
        dto.setPhone(s.getPhone());
        dto.setAddress(s.getAddress());
        if (s.getDepartment() != null) {
            dto.setDepartmentName(s.getDepartment().getName());
        }
        return dto;
    }
}