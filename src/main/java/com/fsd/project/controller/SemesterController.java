package com.fsd.project.controller;

import com.fsd.project.dto.SemesterDTO;
import com.fsd.project.model.Semester;
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

    @PostMapping
    public ResponseEntity<Semester> createSemester(@RequestBody SemesterDTO dto) {
        return new ResponseEntity<>(semesterService.createSemester(dto), HttpStatus.CREATED);
    }
}