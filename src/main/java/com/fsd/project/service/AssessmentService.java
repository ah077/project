package com.fsd.project.service;

import com.fsd.project.dto.AssessmentDTO;
import com.fsd.project.exception.ResourceNotFoundException;
import com.fsd.project.model.Assessment;
import com.fsd.project.model.Subject;
import com.fsd.project.repo.AssessmentRepository;
import com.fsd.project.repo.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        if (dto.getSubjectId() != null) {
            Subject subject = subjectRepository.findById(dto.getSubjectId())
                    .orElseThrow(() -> new ResourceNotFoundException("Subject not found with id: " + dto.getSubjectId()));
            assessment.setSubject(subject);
        }

        return assessmentRepository.save(assessment);
    }
}
