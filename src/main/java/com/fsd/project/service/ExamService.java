package com.fsd.project.service;

import com.fsd.project.dto.ExamDTO;
import com.fsd.project.exception.ResourceNotFoundException;
import com.fsd.project.model.Exam;
import com.fsd.project.repo.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ExamService {
    @Autowired private ExamRepository examRepository;

    public List<ExamDTO> getAllExams() {
        return examRepository.findAll().stream()
            .map(this::mapEntityToDto)
            .collect(Collectors.toList());
    }

    public ExamDTO getExamById(Long id) {
        return examRepository.findById(id)
            .map(this::mapEntityToDto)
            .orElseThrow(() -> new ResourceNotFoundException("Exam not found with id: " + id));
    }

    @Transactional
    public ExamDTO createExam(ExamDTO dto) {
        Exam e = new Exam();
        e.setName(dto.getName());
        e.setDate(dto.getDate());
        e.setType(dto.getType());
        e.setTotalMarks(dto.getTotalMarks());
        Exam savedExam = examRepository.save(e);
        // ✅ FIX: Return the mapped DTO
        return mapEntityToDto(savedExam);
    }

    @Transactional
    public ExamDTO updateExam(Long id, ExamDTO dto) {
        Exam e = examRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exam not found with id: " + id));
        e.setName(dto.getName());
        e.setDate(dto.getDate());
        e.setType(dto.getType());
        e.setTotalMarks(dto.getTotalMarks());
        Exam updatedExam = examRepository.save(e);
        // ✅ FIX: Return the mapped DTO
        return mapEntityToDto(updatedExam);
    }

    @Transactional
    public void deleteExam(Long id) {
        if (!examRepository.existsById(id)) {
            throw new ResourceNotFoundException("Exam not found with id: " + id);
        }
        examRepository.deleteById(id);
    }

    private ExamDTO mapEntityToDto(Exam exam) {
        ExamDTO dto = new ExamDTO();
        dto.setId(exam.getId());
        dto.setName(exam.getName());
        dto.setDate(exam.getDate());
        dto.setType(exam.getType());
        dto.setTotalMarks(exam.getTotalMarks());
        return dto;
    }
}