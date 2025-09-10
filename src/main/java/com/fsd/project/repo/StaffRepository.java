package com.fsd.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsd.project.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long> {}
