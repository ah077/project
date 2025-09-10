package com.fsd.project.controller;

import com.fsd.project.model.ExamResult;
import com.fsd.project.service.ExamResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exam-results")
public class ExamResultController {

    @Autowired
    private ExamResultService examResultService;

    @GetMapping
    public List<ExamResult> getAllExamResults() {
        return examResultService.getAllExamResults();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamResult> getExamResultById(@PathVariable Long id) {
        ExamResult examResult = examResultService.getExamResultById(id);
        return ResponseEntity.ok(examResult);
    }

    @PostMapping
    public ResponseEntity<ExamResult> createExamResult(@RequestBody ExamResult examResult) {
        ExamResult createdResult = examResultService.createExamResult(examResult);
        return new ResponseEntity<>(createdResult, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExamResult> updateExamResult(@PathVariable Long id, @RequestBody ExamResult resultDetails) {
        ExamResult updatedResult = examResultService.updateExamResult(id, resultDetails);
        return ResponseEntity.ok(updatedResult);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExamResult(@PathVariable Long id) {
        examResultService.deleteExamResult(id);
        return ResponseEntity.noContent().build();
    }
}