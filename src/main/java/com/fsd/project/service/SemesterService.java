package com.fsd.project.service;

import com.fsd.project.dto.SemesterDTO;
import com.fsd.project.exception.ResourceNotFoundException;
import com.fsd.project.model.Semester;
import com.fsd.project.repo.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class SemesterService {

    @Autowired private SemesterRepository semesterRepository;

    public List<SemesterDTO> getAllSemesters() {
        return semesterRepository.findAll().stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public Semester createSemester(SemesterDTO dto) {
        Semester s = new Semester();
        s.setSno(dto.getSno());
        s.setStage(dto.getStage());
        s.setEndYear(dto.getEndYear());
        return semesterRepository.save(s);
    }

    private SemesterDTO mapEntityToDto(Semester s) {
        SemesterDTO dto = new SemesterDTO();
        dto.setId(s.getId());
        dto.setSno(s.getSno());
        dto.setStage(s.getStage());
        dto.setEndYear(s.getEndYear());
        return dto;
    }
}