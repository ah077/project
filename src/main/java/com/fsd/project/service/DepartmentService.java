package com.fsd.project.service;

import com.fsd.project.exception.ResourceNotFoundException;
import com.fsd.project.model.Department;
import com.fsd.project.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id, Department departmentDetails) {
        Department existingDepartment = getDepartmentById(id);
        existingDepartment.setName(departmentDetails.getName());
        existingDepartment.setIntake(departmentDetails.getIntake());
        existingDepartment.setHod(departmentDetails.getHod());
        return departmentRepository.save(existingDepartment);
    }

    public void deleteDepartment(Long id) {
        if (!departmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Department not found with id: " + id);
        }
        departmentRepository.deleteById(id);
    }
}