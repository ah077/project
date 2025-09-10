package com.fsd.project.service;

import com.fsd.project.exception.ResourceNotFoundException;
import com.fsd.project.model.Subject;
import com.fsd.project.repo.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found with id: " + id));
    }

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject updateSubject(Long id, Subject subjectDetails) {
        Subject existingSubject = getSubjectById(id);
        existingSubject.setName(subjectDetails.getName());
        existingSubject.setCode(subjectDetails.getCode());
        existingSubject.setCredits(subjectDetails.getCredits());
        existingSubject.setDuration(subjectDetails.getDuration());
        return subjectRepository.save(existingSubject);
    }

    public void deleteSubject(Long id) {
        if (!subjectRepository.existsById(id)) {
            throw new ResourceNotFoundException("Subject not found with id: " + id);
        }
        subjectRepository.deleteById(id);
    }
}