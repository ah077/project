package com.fsd.project.service;

import com.fsd.project.exception.ResourceNotFoundException;
import com.fsd.project.model.Semester;
import com.fsd.project.repo.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.fsd.project.dto.SemesterDTO;

@Service
public class SemesterService {

    @Autowired private SemesterRepository semesterRepository;

    public List<Semester> getAllSemesters() {
        return semesterRepository.findAll();
    }

    public Semester getSemesterById(Long id) {
        return semesterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Semester not found with id: " + id));
    }

    public Semester createSemester(SemesterDTO dto) {
        Semester s = new Semester();
        s.setSno(dto.getSno());
        s.setStage(dto.getStage());
        s.setEndYear(dto.getEndYear());
        return semesterRepository.save(s);
    }

    public Semester updateSemester(Long id, SemesterDTO dto) {
        Semester s = getSemesterById(id);
        s.setSno(dto.getSno());
        s.setStage(dto.getStage());
        s.setEndYear(dto.getEndYear());
        return semesterRepository.save(s);
    }

    public void deleteSemester(Long id) {
        if (!semesterRepository.existsById(id))
            throw new ResourceNotFoundException("Semester not found with id: " + id);
        semesterRepository.deleteById(id);
    }
}


