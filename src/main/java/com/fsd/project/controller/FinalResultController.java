package com.fsd.project.controller;

import com.fsd.project.model.FinalResult;
import com.fsd.project.service.FinalResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/final-results")
public class FinalResultController {

    @Autowired
    private FinalResultService finalResultService;

    @GetMapping
    public List<FinalResult> getAllFinalResults() {
        return finalResultService.getAllFinalResults();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinalResult> getFinalResultById(@PathVariable Long id) {
        FinalResult finalResult = finalResultService.getFinalResultById(id);
        return ResponseEntity.ok(finalResult);
    }

    @PostMapping
    public ResponseEntity<FinalResult> createFinalResult(@RequestBody FinalResult finalResult) {
        FinalResult createdResult = finalResultService.createFinalResult(finalResult);
        return new ResponseEntity<>(createdResult, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FinalResult> updateFinalResult(@PathVariable Long id, @RequestBody FinalResult resultDetails) {
        FinalResult updatedResult = finalResultService.updateFinalResult(id, resultDetails);
        return ResponseEntity.ok(updatedResult);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFinalResult(@PathVariable Long id) {
        finalResultService.deleteFinalResult(id);
        return ResponseEntity.noContent().build();
    }
}