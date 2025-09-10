package com.fsd.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsd.project.model.Semester;

public interface SemesterRepository extends JpaRepository<Semester, Long> {}
