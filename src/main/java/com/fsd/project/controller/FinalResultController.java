package com.fsd.project.controller;

import com.fsd.project.dto.FinalResultDTO;
import com.fsd.project.model.FinalResult;
import com.fsd.project.service.FinalResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/finalresults")
public class FinalResultController {

    @Autowired
    private FinalResultService finalResultService;

    @GetMapping
    public List<FinalResultDTO> getAll() {
        return finalResultService.getAllFinalResults();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinalResultDTO> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(finalResultService.getFinalResultById(id));
    }

    @PostMapping
    public ResponseEntity<FinalResult> create(@RequestBody FinalResultDTO dto) {
        FinalResult saved = finalResultService.createFinalResult(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        finalResultService.deleteFinalResult(id);
        return ResponseEntity.noContent().build();
    }
}