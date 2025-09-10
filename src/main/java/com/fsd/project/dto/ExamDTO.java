package com.fsd.project.dto;

import java.time.LocalDate;

public class ExamDTO {
    private Long id;
    private String name;
    private LocalDate date;
    private String type;
    private Integer totalMarks;
	public ExamDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExamDTO(Long id, String name, LocalDate date, String type, Integer totalMarks) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.type = type;
		this.totalMarks = totalMarks;
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

    
}
