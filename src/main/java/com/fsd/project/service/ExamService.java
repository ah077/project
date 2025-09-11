package com.fsd.project.service;

import com.fsd.project.dto.ExamDTO;
import com.fsd.project.exception.ResourceNotFoundException;
import com.fsd.project.model.Exam;
import com.fsd.project.repo.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    public Exam getExamById(Long id) {
        return examRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exam not found with id: " + id));
    }

    public Exam createExam(ExamDTO dto) {
        Exam e = new Exam();
        e.setName(dto.getName());
        e.setDate(dto.getDate());
        e.setType(dto.getType());
        e.setTotalMarks(dto.getTotalMarks());
        return examRepository.save(e);
    }
}
