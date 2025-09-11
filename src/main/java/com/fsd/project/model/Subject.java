package com.fsd.project.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name = "subjects")
public class Subject {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String name;
    private Integer credits;
    private Integer duration;

    // Subject <-> Student handled in Student entity ( ManyToMany )

    // Subject <-> Assessment : diagram shows M..M, so many-to-many
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "subject_assessment",
        joinColumns = @JoinColumn(name = "subject_id"),
        inverseJoinColumns = @JoinColumn(name = "assessment_id")
    )
//    @JsonManagedReference("subject-assessment")
    private Set<Assessment> assessments;

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(Long id, String code, String name, Integer credits, Integer duration, Set<Assessment> assessments) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.credits = credits;
		this.duration = duration;
		this.assessments = assessments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Set<Assessment> getAssessments() {
		return assessments;
	}

	public void setAssessments(Set<Assessment> assessments) {
		this.assessments = assessments;
	}

   
}
