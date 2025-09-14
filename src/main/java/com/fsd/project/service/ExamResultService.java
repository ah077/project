package com.fsd.project.service;

import com.fsd.project.dto.ExamResultDTO;
import com.fsd.project.exception.ResourceNotFoundException;
import com.fsd.project.model.Exam;
import com.fsd.project.model.ExamResult;
import com.fsd.project.model.Student;
import com.fsd.project.repo.ExamRepository;
import com.fsd.project.repo.ExamResultRepository;
import com.fsd.project.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ExamResultService {

    @Autowired private ExamResultRepository examResultRepository;
    @Autowired private ExamRepository examRepository;
    @Autowired private StudentRepository studentRepository;

    public List<ExamResultDTO> getAllExamResults() {
        return examResultRepository.findAll().stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    public ExamResultDTO getExamResultById(Long id) {
        return examResultRepository.findById(id)
                .map(this::mapEntityToDto)
                .orElseThrow(() -> new ResourceNotFoundException("ExamResult not found with id " + id));
    }

    @Transactional
    public ExamResult createExamResult(ExamResultDTO dto) {
        ExamResult result = new ExamResult();
        result.setMarks(dto.getMarks());
        result.setGrade(dto.getGrade());

        Exam exam = examRepository.findById(dto.getExamId())
                .orElseThrow(() -> new ResourceNotFoundException("Exam not found with id: " + dto.getExamId()));
        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + dto.getStudentId()));

        result.setExam(exam);
        result.setStudent(student);

        return examResultRepository.save(result);
    }

    private ExamResultDTO mapEntityToDto(ExamResult er) {
        ExamResultDTO dto = new ExamResultDTO();
        dto.setId(er.getId());
        dto.setMarks(er.getMarks());
        dto.setGrade(er.getGrade());
        if (er.getExam() != null) {
            dto.setExamName(er.getExam().getName());
        }
        if (er.getStudent() != null) {
            dto.setStudentName(er.getStudent().getName());
        }
        return dto;
    }
}