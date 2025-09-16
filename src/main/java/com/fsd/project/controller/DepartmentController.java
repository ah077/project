package com.fsd.project.controller;

import com.fsd.project.dto.DepartmentDTO;
import com.fsd.project.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    @Autowired private DepartmentService departmentService;

    @GetMapping
    public List<DepartmentDTO> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO dto) {
        DepartmentDTO createdDepartment = departmentService.createDepartment(dto);
        return new ResponseEntity<>(createdDepartment, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable Long id, @RequestBody DepartmentDTO dto) {
        DepartmentDTO updatedDepartment = departmentService.updateDepartment(id, dto);
        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}