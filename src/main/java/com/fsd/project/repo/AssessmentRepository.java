package com.fsd.project.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fsd.project.model.Assessment;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {}

