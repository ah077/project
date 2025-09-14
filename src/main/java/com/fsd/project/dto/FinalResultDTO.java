package com.fsd.project.dto;

public class FinalResultDTO {
    // For Responses
    private Long id;
    private Integer subTotal;
    private Integer total;
    private Double percentage;
    private String grade;
    private String studentName;
    private String semesterInfo;

    // For Requests
    private Long studentId;
    private Long semesterId;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Integer getSubTotal() { return subTotal; }
    public void setSubTotal(Integer subTotal) { this.subTotal = subTotal; }
    public Integer getTotal() { return total; }
    public void setTotal(Integer total) { this.total = total; }
    public Double getPercentage() { return percentage; }
    public void setPercentage(Double percentage) { this.percentage = percentage; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public String getSemesterInfo() { return semesterInfo; }
    public void setSemesterInfo(String semesterInfo) { this.semesterInfo = semesterInfo; }
    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }
    public Long getSemesterId() { return semesterId; }
    public void setSemesterId(Long semesterId) { this.semesterId = semesterId; }
}