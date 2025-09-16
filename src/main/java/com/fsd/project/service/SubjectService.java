package com.fsd.project.service;

import com.fsd.project.dto.SubjectDTO;
import com.fsd.project.exception.ResourceNotFoundException;
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

    public SubjectDTO getSubjectById(Long id) {
        return subjectRepository.findById(id)
                .map(this::mapEntityToDto)
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found with id: " + id));
    }

    @Transactional
    public SubjectDTO createSubject(SubjectDTO dto) {
        Subject s = new Subject();
        s.setCode(dto.getCode());
        s.setName(dto.getName());
        s.setCredits(dto.getCredits());
        s.setDuration(dto.getDuration());
        Subject savedSubject = subjectRepository.save(s);
        return mapEntityToDto(savedSubject);
    }

    @Transactional
    public SubjectDTO updateSubject(Long id, SubjectDTO dto) {
        Subject s = subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found with id: " + id));
        s.setCode(dto.getCode());
        s.setName(dto.getName());
        s.setCredits(dto.getCredits());
        s.setDuration(dto.getDuration());
        Subject updatedSubject = subjectRepository.save(s);
        return mapEntityToDto(updatedSubject);
    }

    @Transactional
    public void deleteSubject(Long id) {
        if (!subjectRepository.existsById(id)) {
            throw new ResourceNotFoundException("Subject not found with id: " + id);
        }
        subjectRepository.deleteById(id);
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