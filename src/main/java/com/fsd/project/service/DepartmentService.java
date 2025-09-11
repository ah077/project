package com.fsd.project.service;

import com.fsd.project.dto.DepartmentDTO;
import com.fsd.project.exception.ResourceNotFoundException;
import com.fsd.project.model.Department;
import com.fsd.project.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
    }

    public Department createDepartment(DepartmentDTO dto) {
        Department d = new Department();
        d.setName(dto.getName());
        d.setIntake(dto.getIntake());
        d.setHod(dto.getHod());
        return departmentRepository.save(d);
    }

    public Department updateDepartment(Long id, DepartmentDTO dto) {
        Department d = getDepartmentById(id);
        d.setName(dto.getName());
        d.setIntake(dto.getIntake());
        d.setHod(dto.getHod());
        return departmentRepository.save(d);
    }

    public void deleteDepartment(Long id) {
        if (!departmentRepository.existsById(id))
            throw new ResourceNotFoundException("Department not found with id: " + id);
        departmentRepository.deleteById(id);
    }
}
