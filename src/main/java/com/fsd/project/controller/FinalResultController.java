package com.fsd.project.controller;

import com.fsd.project.dto.FinalResultDTO;
import com.fsd.project.model.FinalResult;
import com.fsd.project.service.FinalResultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/final-results")
@CrossOrigin(origins = "http://localhost:3000")
public class FinalResultController {

    private final FinalResultService service;

    public FinalResultController(FinalResultService service) {
        this.service = service;
    }

    @GetMapping
    public List<FinalResult> getAll() {
        return service.getAll();
    }

    @PostMapping
    public FinalResult create(@RequestBody FinalResultDTO dto) {
        return service.create(dto);
    }
}
