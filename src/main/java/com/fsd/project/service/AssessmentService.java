package com.fsd.project.service;

import com.fsd.project.dto.AssessmentDTO;
import com.fsd.project.exception.ResourceNotFoundException;
import com.fsd.project.model.Assessment;
import com.fsd.project.model.Subject;
import com.fsd.project.repo.AssessmentRepository;
import com.fsd.project.repo.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet; // Import HashSet
import java.util.List;
import java.util.Set;    // Import Set

@Service
public class AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Assessment> getAllAssessments() {
        return assessmentRepository.findAll();
    }

    public Assessment getAssessmentById(Long id) {
        return assessmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Assessment not found with id: " + id));
    }

    public Assessment createAssessment(AssessmentDTO dto) {
        Assessment assessment = new Assessment();
        assessment.setNumber(dto.getNumber());
        assessment.setDate(dto.getDate());
        assessment.setMarks(dto.getMarks());
        assessment.setTotalMarks(dto.getTotalMarks());

        // Since the relationship is ManyToMany, you might want to handle multiple subject IDs here in the future.
        // For now, we'll handle the single ID from the DTO.
        if (dto.getSubjectId() != null) {
            Subject subject = subjectRepository.findById(dto.getSubjectId())
                    .orElseThrow(() -> new ResourceNotFoundException("Subject not found with id: " + dto.getSubjectId()));
            
            // ✅ CORRECTION: Create a set and add the single subject to it
            Set<Subject> subjectSet = new HashSet<>();
            subjectSet.add(subject);
            
            // Now, pass the set to the setter method
            assessment.setSubjects(subjectSet);

            // Also, update the other side of the relationship
            subject.getAssessments().add(assessment);
        }

        return assessmentRepository.save(assessment);
    }
}