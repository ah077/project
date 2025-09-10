package com.fsd.project.service;

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

    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }

    public Exam updateExam(Long id, Exam examDetails) {
        Exam existingExam = getExamById(id);
        existingExam.setName(examDetails.getName());
        existingExam.setDate(examDetails.getDate());
        existingExam.setType(examDetails.getType());
        existingExam.setTotalMarks(examDetails.getTotalMarks());
        return examRepository.save(existingExam);
    }

    public void deleteExam(Long id) {
        if (!examRepository.existsById(id)) {
            throw new ResourceNotFoundException("Exam not found with id: " + id);
        }
        examRepository.deleteById(id);
    }
}