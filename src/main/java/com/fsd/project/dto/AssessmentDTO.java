package com.fsd.project.dto;

import java.time.LocalDate;

public class AssessmentDTO {
    private Long id;
    private String number;
    private LocalDate date;
    private Integer marks;
    private Integer totalMarks;
    private Long subjectId;
	public AssessmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AssessmentDTO(Long id, String number, LocalDate date, Integer marks, Integer totalMarks, Long subjectId) {
		super();
		this.id = id;
		this.number = number;
		this.date = date;
		this.marks = marks;
		this.totalMarks = totalMarks;
		this.subjectId = subjectId;
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
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

    
}
