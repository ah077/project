package com.fsd.project.controller;

import com.fsd.project.dto.AssessmentDTO;
import com.fsd.project.model.Assessment;
import com.fsd.project.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/assessments")
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    @GetMapping
    public List<Assessment> getAll() {
        return assessmentService.getAllAssessments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assessment> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(assessmentService.getAssessmentById(id));
    }

    @PostMapping
    public ResponseEntity<Assessment> create(@RequestBody AssessmentDTO dto) {
        Assessment saved = assessmentService.createAssessment(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
