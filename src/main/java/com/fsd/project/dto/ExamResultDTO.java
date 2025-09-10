package com.fsd.project.dto;

public class ExamResultDTO {
    private Long id;
    private Integer marks;
    private String grade;
    private Long examId;
    private Long studentId;
	public ExamResultDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExamResultDTO(Long id, Integer marks, String grade, Long examId, Long studentId) {
		super();
		this.id = id;
		this.marks = marks;
		this.grade = grade;
		this.examId = examId;
		this.studentId = studentId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Long getExamId() {
		return examId;
	}
	public void setExamId(Long examId) {
		this.examId = examId;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
    
    
}
