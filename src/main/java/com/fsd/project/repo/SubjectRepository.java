package com.fsd.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsd.project.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {}

