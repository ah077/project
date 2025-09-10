package com.fsd.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsd.project.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {}
