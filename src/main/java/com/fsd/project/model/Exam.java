package com.fsd.project.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "exams")
public class Exam {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate date;
    private String type;
    private Integer totalMarks;

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    @JsonManagedReference("exam-examresult") // Named reference
    private Set<ExamResult> results;

	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Exam(Long id, String name, LocalDate date, String type, Integer totalMarks, Set<ExamResult> results) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.type = type;
		this.totalMarks = totalMarks;
		this.results = results;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = totalMarks;
	}

	public Set<ExamResult> getResults() {
		return results;
	}

	public void setResults(Set<ExamResult> results) {
		this.results = results;
	}
	
	
}
