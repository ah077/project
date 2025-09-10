package com.fsd.project.service;

import com.fsd.project.exception.ResourceNotFoundException;
import com.fsd.project.model.ExamResult;
import com.fsd.project.repo.ExamResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamResultService {

    @Autowired
    private ExamResultRepository examResultRepository;

    public List<ExamResult> getAllExamResults() {
        return examResultRepository.findAll();
    }

    public ExamResult getExamResultById(Long id) {
        return examResultRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ExamResult not found with id: " + id));
    }

    public ExamResult createExamResult(ExamResult examResult) {
        // Business logic for linking to Exam, Student, FinalResult should be handled here
        return examResultRepository.save(examResult);
    }

    public ExamResult updateExamResult(Long id, ExamResult resultDetails) {
        ExamResult existingResult = getExamResultById(id);
        existingResult.setMarks(resultDetails.getMarks());
        existingResult.setGrade(resultDetails.getGrade());
        return examResultRepository.save(existingResult);
    }

    public void deleteExamResult(Long id) {
        if (!examResultRepository.existsById(id)) {
            throw new ResourceNotFoundException("ExamResult not found with id: " + id);
        }
        examResultRepository.deleteById(id);
    }
}