package com.fsd.project.service;

import com.fsd.project.dto.AssessmentDTO;
import com.fsd.project.model.Assessment;
import com.fsd.project.repo.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class AssessmentService {

    @Autowired private AssessmentRepository assessmentRepository;

    public List<AssessmentDTO> getAllAssessments() {
        return assessmentRepository.findAll().stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public Assessment createAssessment(AssessmentDTO dto) {
        Assessment assessment = new Assessment();
        assessment.setNumber(dto.getNumber());
        assessment.setDate(dto.getDate());
        assessment.setMarks(dto.getMarks());
        assessment.setTotalMarks(dto.getTotalMarks());
        return assessmentRepository.save(assessment);
    }

    private AssessmentDTO mapEntityToDto(Assessment a) {
        AssessmentDTO dto = new AssessmentDTO();
        dto.setId(a.getId());
        dto.setNumber(a.getNumber());
        dto.setDate(a.getDate());
        dto.setMarks(a.getMarks());
        dto.setTotalMarks(a.getTotalMarks());
        return dto;
    }
}