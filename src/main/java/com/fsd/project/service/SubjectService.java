package com.fsd.project.service;

import com.fsd.project.dto.SubjectDTO;
import com.fsd.project.exception.ResourceNotFoundException;
import com.fsd.project.model.Assessment;
import com.fsd.project.model.Subject;
import com.fsd.project.repo.AssessmentRepository;
import com.fsd.project.repo.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private AssessmentRepository assessmentRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found with id: " + id));
    }

    public Subject createSubject(SubjectDTO dto) {
        Subject s = new Subject();
        s.setCode(dto.getCode());
        s.setName(dto.getName());
        s.setCredits(dto.getCredits());
        s.setDuration(dto.getDuration());

        if (dto.getAssessmentIds() != null) {
            Set<Assessment> assessments = new HashSet<>(assessmentRepository.findAllById(dto.getAssessmentIds()));
            s.setAssessments(assessments);
        }

        return subjectRepository.save(s);
    }
}
