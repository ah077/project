package com.fsd.project.controller;

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

    @Autowired
    private SemesterService semesterService;

    @GetMapping
    public List<Semester> getAllSemesters() {
        return semesterService.getAllSemesters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Semester> getSemesterById(@PathVariable Long id) {
        Semester semester = semesterService.getSemesterById(id);
        return ResponseEntity.ok(semester);
    }

    @PostMapping
    public ResponseEntity<Semester> createSemester(@RequestBody Semester semester) {
        Semester createdSemester = semesterService.createSemester(semester);
        return new ResponseEntity<>(createdSemester, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Semester> updateSemester(@PathVariable Long id, @RequestBody Semester semesterDetails) {
        Semester updatedSemester = semesterService.updateSemester(id, semesterDetails);
        return ResponseEntity.ok(updatedSemester);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSemester(@PathVariable Long id) {
        semesterService.deleteSemester(id);
        return ResponseEntity.noContent().build();
    }
}