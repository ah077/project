package com.fsd.project.service;

import com.fsd.project.exception.ResourceNotFoundException;
import com.fsd.project.model.Semester;
import com.fsd.project.repo.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterService {

    @Autowired
    private SemesterRepository semesterRepository;

    public List<Semester> getAllSemesters() {
        return semesterRepository.findAll();
    }

    public Semester getSemesterById(Long id) {
        return semesterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Semester not found with id: " + id));
    }

    public Semester createSemester(Semester semester) {
        return semesterRepository.save(semester);
    }

    public Semester updateSemester(Long id, Semester semesterDetails) {
        Semester existingSemester = getSemesterById(id);
        existingSemester.setSno(semesterDetails.getSno());
        existingSemester.setStage(semesterDetails.getStage());
        existingSemester.setEndYear(semesterDetails.getEndYear());
        return semesterRepository.save(existingSemester);
    }

    public void deleteSemester(Long id) {
        if (!semesterRepository.existsById(id)) {
            throw new ResourceNotFoundException("Semester not found with id: " + id);
        }
        semesterRepository.deleteById(id);
    }
}