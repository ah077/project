package com.fsd.project.service;

import com.fsd.project.dto.DepartmentDTO;
import com.fsd.project.exception.ResourceNotFoundException;
import com.fsd.project.model.Department;
import com.fsd.project.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class DepartmentService {

    @Autowired private DepartmentRepository departmentRepository;

    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll().stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    public DepartmentDTO getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .map(this::mapEntityToDto)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
    }

    @Transactional
    public DepartmentDTO createDepartment(DepartmentDTO dto) {
        Department d = new Department();
        d.setName(dto.getName());
        d.setIntake(dto.getIntake());
        d.setHod(dto.getHod());
        Department savedDepartment = departmentRepository.save(d);
        // ✅ FIX: Return the mapped DTO
        return mapEntityToDto(savedDepartment);
    }

    @Transactional
    public DepartmentDTO updateDepartment(Long id, DepartmentDTO dto) {
        Department d = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
        d.setName(dto.getName());
        d.setIntake(dto.getIntake());
        d.setHod(dto.getHod());
        Department updatedDepartment = departmentRepository.save(d);
        // ✅ FIX: Return the mapped DTO
        return mapEntityToDto(updatedDepartment);
    }

    @Transactional
    public void deleteDepartment(Long id) {
        if (!departmentRepository.existsById(id))
            throw new ResourceNotFoundException("Department not found with id: " + id);
        departmentRepository.deleteById(id);
    }

    private DepartmentDTO mapEntityToDto(Department d) {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setId(d.getId());
        dto.setName(d.getName());
        dto.setIntake(d.getIntake());
        dto.setHod(d.getHod());
        return dto;
    }
}