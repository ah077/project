package com.fsd.project.dto;

public class ExamResultDTO {
    // For Responses
    private Long id;
    private Integer marks;
    private String grade;
    private String examName;
    private String studentName;

    private Long examId;
    private Long studentId;
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Integer getMarks() { return marks; }
    public void setMarks(Integer marks) { this.marks = marks; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
    public String getExamName() { return examName; }
    public void setExamName(String examName) { this.examName = examName; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public Long getExamId() { return examId; }
    public void setExamId(Long examId) { this.examId = examId; }
    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }
}