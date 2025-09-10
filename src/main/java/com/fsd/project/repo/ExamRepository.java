package com.fsd.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsd.project.model.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {}
