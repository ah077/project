package com.fsd.project.service;

import com.fsd.project.dto.SubjectDTO;
import com.fsd.project.model.Subject;
import com.fsd.project.repo.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class SubjectService {

    @Autowired private SubjectRepository subjectRepository;

    public List<SubjectDTO> getAllSubjects() {
        return subjectRepository.findAll().stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public Subject createSubject(SubjectDTO dto) {
        Subject s = new Subject();
        s.setCode(dto.getCode());
        s.setName(dto.getName());
        s.setCredits(dto.getCredits());
        s.setDuration(dto.getDuration());
        return subjectRepository.save(s);
    }

    private SubjectDTO mapEntityToDto(Subject s) {
        SubjectDTO dto = new SubjectDTO();
        dto.setId(s.getId());
        dto.setCode(s.getCode());
        dto.setName(s.getName());
        dto.setCredits(s.getCredits());
        dto.setDuration(s.getDuration());
        return dto;
    }
}