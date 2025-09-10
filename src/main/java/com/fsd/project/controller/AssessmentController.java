package com.fsd.project.controller;

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
    public List<Assessment> getAllAssessments() {
        return assessmentService.getAllAssessments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assessment> getAssessmentById(@PathVariable Long id) {
        Assessment assessment = assessmentService.getAssessmentById(id);
        return ResponseEntity.ok(assessment);
    }

    @PostMapping
    public ResponseEntity<Assessment> createAssessment(@RequestBody Assessment assessment) {
        Assessment createdAssessment = assessmentService.createAssessment(assessment);
        return new ResponseEntity<>(createdAssessment, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assessment> updateAssessment(@PathVariable Long id, @RequestBody Assessment assessmentDetails) {
        Assessment updatedAssessment = assessmentService.updateAssessment(id, assessmentDetails);
        return ResponseEntity.ok(updatedAssessment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssessment(@PathVariable Long id) {
        assessmentService.deleteAssessment(id);
        return ResponseEntity.noContent().build();
    }
}