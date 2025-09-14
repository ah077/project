package com.fsd.project.controller;

import com.fsd.project.dto.ExamResultDTO;
import com.fsd.project.model.ExamResult;
import com.fsd.project.service.ExamResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/examresults")
public class ExamResultController {

    @Autowired private ExamResultService examResultService;

    @GetMapping
    public List<ExamResultDTO> getAll() {
        return examResultService.getAllExamResults();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamResultDTO> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(examResultService.getExamResultById(id));
    }

    @PostMapping
    public ResponseEntity<ExamResult> create(@RequestBody ExamResultDTO dto) {
        ExamResult saved = examResultService.createExamResult(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        examResultService.deleteExamResult(id);
        return ResponseEntity.noContent().build();
    }
}