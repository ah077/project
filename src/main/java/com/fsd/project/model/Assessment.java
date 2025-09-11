package com.fsd.project.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "assessments")
public class Assessment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number; // No
    private LocalDate date;
    private Integer marks;
    private Integer totalMarks;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    @JsonIgnore 
    private Subject subject;

	public Assessment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Assessment(Long id, String number, LocalDate date, Integer marks, Integer totalMarks,
			Subject subjects) {
		super();
		this.id = id;
		this.number = number;
		this.date = date;
		this.marks = marks;
		this.totalMarks = totalMarks;
		this.subject = subjects;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public Integer getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = totalMarks;
	}

	public Subject getSubject() {
	    return subject;
	}
	public void setSubject(Subject subject) {
	    this.subject = subject;
	}
	

   
}

