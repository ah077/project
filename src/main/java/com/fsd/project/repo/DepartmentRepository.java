package com.fsd.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsd.project.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {}
