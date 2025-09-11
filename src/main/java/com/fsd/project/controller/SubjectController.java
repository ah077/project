package com.fsd.project.controller;

import com.fsd.project.dto.SubjectDTO;
import com.fsd.project.model.Subject;
import com.fsd.project.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public List<Subject> getAll() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subject> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(subjectService.getSubjectById(id));
    }

    @PostMapping
    public ResponseEntity<Subject> create(@RequestBody SubjectDTO dto) {
        return new ResponseEntity<>(subjectService.createSubject(dto), HttpStatus.CREATED);
    }
}
