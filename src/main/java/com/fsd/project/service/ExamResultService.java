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

import java.util.List;

@Service
public class ExamResultService {

    @Autowired
    private ExamResultRepository examResultRepository;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private StudentRepository studentRepository;

    public List<ExamResult> getAllExamResults() {
        return examResultRepository.findAll();
    }

    public ExamResult getExamResultById(Long id) {
        return examResultRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ExamResult not found with id: " + id));
    }

    public ExamResult createExamResult(ExamResultDTO dto) {
        ExamResult result = new ExamResult();
        result.setMarks(dto.getMarks());

        Exam exam = examRepository.findById(dto.getExamId())
                .orElseThrow(() -> new ResourceNotFoundException("Exam not found with id: " + dto.getExamId()));
        result.setExam(exam);

        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + dto.getStudentId()));
        result.setStudent(student);

        return examResultRepository.save(result);
    }
}
