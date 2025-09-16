package com.fsd.project.controller;

import com.fsd.project.dto.StaffDTO;
import com.fsd.project.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/staff")
public class StaffController {
    @Autowired private StaffService staffService;

    @GetMapping
    public List<StaffDTO> getAll() {
        return staffService.getAllStaff();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StaffDTO> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(staffService.getStaffById(id));
    }

    @PostMapping
    public ResponseEntity<StaffDTO> create(@RequestBody StaffDTO dto) {
        StaffDTO createdStaff = staffService.createStaff(dto);
        return new ResponseEntity<>(createdStaff, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StaffDTO> update(@PathVariable Long id, @RequestBody StaffDTO dto) {
        StaffDTO updatedStaff = staffService.updateStaff(id, dto);
        return ResponseEntity.ok(updatedStaff);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        staffService.deleteStaff(id);
        return ResponseEntity.noContent().build();
    }
}