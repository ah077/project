package com.fsd.project.controller;

import com.fsd.project.dto.ExamDTO;
import com.fsd.project.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/exams")
public class ExamController {
    @Autowired private ExamService examService;

    @GetMapping
    public List<ExamDTO> getAll() {
        return examService.getAllExams();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamDTO> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(examService.getExamById(id));
    }

    @PostMapping
    public ResponseEntity<ExamDTO> create(@RequestBody ExamDTO dto) {
        ExamDTO createdExam = examService.createExam(dto);
        return new ResponseEntity<>(createdExam, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExamDTO> update(@PathVariable Long id, @RequestBody ExamDTO dto) {
        ExamDTO updatedExam = examService.updateExam(id, dto);
        return ResponseEntity.ok(updatedExam);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        examService.deleteExam(id);
        return ResponseEntity.noContent().build();
    }
}