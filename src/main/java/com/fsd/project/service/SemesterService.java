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

    public SemesterDTO getSemesterById(Long id) {
        return semesterRepository.findById(id)
                .map(this::mapEntityToDto)
                .orElseThrow(() -> new ResourceNotFoundException("Semester not found with id: " + id));
    }

    @Transactional
    public SemesterDTO createSemester(SemesterDTO dto) {
        Semester s = new Semester();
        s.setSno(dto.getSno());
        s.setStage(dto.getStage());
        s.setEndYear(dto.getEndYear());
        Semester savedSemester = semesterRepository.save(s);
        // ✅ FIX: Return the mapped DTO
        return mapEntityToDto(savedSemester);
    }

    @Transactional
    public SemesterDTO updateSemester(Long id, SemesterDTO dto) {
        Semester s = semesterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Semester not found with id: " + id));
        s.setSno(dto.getSno());
        s.setStage(dto.getStage());
        s.setEndYear(dto.getEndYear());
        Semester updatedSemester = semesterRepository.save(s);
        // ✅ FIX: Return the mapped DTO
        return mapEntityToDto(updatedSemester);
    }

    @Transactional
    public void deleteSemester(Long id) {
        if (!semesterRepository.existsById(id))
            throw new ResourceNotFoundException("Semester not found with id: " + id);
        semesterRepository.deleteById(id);
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