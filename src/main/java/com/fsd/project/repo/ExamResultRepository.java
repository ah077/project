package com.fsd.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsd.project.model.ExamResult;

public interface ExamResultRepository extends JpaRepository<ExamResult, Long> {}

