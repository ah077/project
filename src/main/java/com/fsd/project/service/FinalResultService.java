package com.fsd.project.service;

import com.fsd.project.exception.ResourceNotFoundException;
import com.fsd.project.model.FinalResult;
import com.fsd.project.repo.FinalResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalResultService {

    @Autowired
    private FinalResultRepository finalResultRepository;

    public List<FinalResult> getAllFinalResults() {
        return finalResultRepository.findAll();
    }

    public FinalResult getFinalResultById(Long id) {
        return finalResultRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FinalResult not found with id: " + id));
    }

    public FinalResult createFinalResult(FinalResult finalResult) {
        // Business logic to calculate total, percentage, and grade can be added here
        return finalResultRepository.save(finalResult);
    }

    public FinalResult updateFinalResult(Long id, FinalResult resultDetails) {
        FinalResult existingResult = getFinalResultById(id);
        existingResult.setSubTotal(resultDetails.getSubTotal());
        existingResult.setTotal(resultDetails.getTotal());
        existingResult.setPercentage(resultDetails.getPercentage());
        existingResult.setGrade(resultDetails.getGrade());
        return finalResultRepository.save(existingResult);
    }

    public void deleteFinalResult(Long id) {
        if (!finalResultRepository.existsById(id)) {
            throw new ResourceNotFoundException("FinalResult not found with id: " + id);
        }
        finalResultRepository.deleteById(id);
    }
}