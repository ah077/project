package com.fsd.project.controller;

import com.fsd.project.dto.ExamDTO;
import com.fsd.project.model.Exam;
import com.fsd.project.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exams")
public class ExamController {

    @Autowired
    private ExamService examService;

    @GetMapping
    public List<Exam> getAll() {
        return examService.getAllExams();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exam> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(examService.getExamById(id));
    }

    @PostMapping
    public ResponseEntity<Exam> create(@RequestBody ExamDTO dto) {
        return new ResponseEntity<>(examService.createExam(dto), HttpStatus.CREATED);
    }
}
