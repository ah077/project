package com.fsd.project.controller;

import com.fsd.project.dto.SemesterDTO;
import com.fsd.project.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/semesters")
public class SemesterController {
    @Autowired private SemesterService semesterService;

    @GetMapping
    public List<SemesterDTO> getAllSemesters() {
        return semesterService.getAllSemesters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SemesterDTO> getSemesterById(@PathVariable Long id) {
        return ResponseEntity.ok(semesterService.getSemesterById(id));
    }

    @PostMapping
    public ResponseEntity<SemesterDTO> createSemester(@RequestBody SemesterDTO dto) {
        SemesterDTO createdSemester = semesterService.createSemester(dto);
        return new ResponseEntity<>(createdSemester, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SemesterDTO> updateSemester(@PathVariable Long id, @RequestBody SemesterDTO dto) {
        SemesterDTO updatedSemester = semesterService.updateSemester(id, dto);
        return ResponseEntity.ok(updatedSemester);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSemester(@PathVariable Long id) {
        semesterService.deleteSemester(id);
        return ResponseEntity.noContent().build();
    }
}