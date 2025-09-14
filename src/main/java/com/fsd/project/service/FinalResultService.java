package com.fsd.project.service;

import com.fsd.project.dto.FinalResultDTO;
import com.fsd.project.exception.ResourceNotFoundException;
import com.fsd.project.model.FinalResult;
import com.fsd.project.model.Semester;
import com.fsd.project.model.Student;
import com.fsd.project.repo.FinalResultRepository;
import com.fsd.project.repo.SemesterRepository;
import com.fsd.project.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class FinalResultService {

    @Autowired private FinalResultRepository finalResultRepository;
    @Autowired private StudentRepository studentRepository;
    @Autowired private SemesterRepository semesterRepository;

    public List<FinalResultDTO> getAllFinalResults() {
        return finalResultRepository.findAll().stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public FinalResult createFinalResult(FinalResultDTO dto) {
        FinalResult result = new FinalResult();
        result.setSubTotal(dto.getSubTotal());
        result.setTotal(dto.getTotal());
        result.setPercentage(dto.getPercentage());
        result.setGrade(dto.getGrade());

        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + dto.getStudentId()));
        Semester semester = semesterRepository.findById(dto.getSemesterId())
                .orElseThrow(() -> new ResourceNotFoundException("Semester not found with id: " + dto.getSemesterId()));

        result.setStudent(student);
        result.setSemester(semester);

        return finalResultRepository.save(result);
    }
    
    private FinalResultDTO mapEntityToDto(FinalResult fr) {
        FinalResultDTO dto = new FinalResultDTO();
        dto.setId(fr.getId());
        dto.setSubTotal(fr.getSubTotal());
        dto.setTotal(fr.getTotal());
        dto.setPercentage(fr.getPercentage());
        dto.setGrade(fr.getGrade());
        if (fr.getStudent() != null) {
            dto.setStudentName(fr.getStudent().getName());
        }
        if (fr.getSemester() != null) {
            dto.setSemesterInfo(fr.getSemester().getSno() + " - " + fr.getSemester().getStage());
        }
        return dto;
    }
}