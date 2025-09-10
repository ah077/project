package com.fsd.project.service;

import com.fsd.project.exception.ResourceNotFoundException;
import com.fsd.project.model.Assessment;
import com.fsd.project.repo.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;

    public List<Assessment> getAllAssessments() {
        return assessmentRepository.findAll();
    }

    public Assessment getAssessmentById(Long id) {
        return assessmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Assessment not found with id: " + id));
    }

    public Assessment createAssessment(Assessment assessment) {
        return assessmentRepository.save(assessment);
    }

    public Assessment updateAssessment(Long id, Assessment assessmentDetails) {
        Assessment existingAssessment = getAssessmentById(id);
        existingAssessment.setNumber(assessmentDetails.getNumber());
        existingAssessment.setDate(assessmentDetails.getDate());
        existingAssessment.setMarks(assessmentDetails.getMarks());
        existingAssessment.setTotalMarks(assessmentDetails.getTotalMarks());
        return assessmentRepository.save(existingAssessment);
    }

    public void deleteAssessment(Long id) {
        if (!assessmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Assessment not found with id: " + id);
        }
        assessmentRepository.deleteById(id);
    }
}