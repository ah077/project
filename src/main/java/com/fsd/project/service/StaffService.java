package com.fsd.project.service;

import com.fsd.project.dto.StaffDTO;
import com.fsd.project.exception.ResourceNotFoundException;
import com.fsd.project.model.Department;
import com.fsd.project.model.Staff;
import com.fsd.project.repo.DepartmentRepository;
import com.fsd.project.repo.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Staff getStaffById(Long id) {
        return staffRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Staff not found with id: " + id));
    }

    public Staff createStaff(StaffDTO dto) {
        Staff s = new Staff();
        s.setName(dto.getName());
        s.setRole(dto.getRole());
        s.setPhone(dto.getPhone());
        s.setAddress(dto.getAddress());

        Department dept = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        s.setDepartment(dept);
        

        return staffRepository.save(s);
    }
}
