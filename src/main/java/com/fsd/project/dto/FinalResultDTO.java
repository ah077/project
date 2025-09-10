package com.fsd.project.dto;

public class FinalResultDTO {
    private Long id;
    private Integer subTotal;
    private Integer total;
    private Double percentage;
    private String grade;
    private Long studentId;
    private Long semesterId;
	public FinalResultDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FinalResultDTO(Long id, Integer subTotal, Integer total, Double percentage, String grade, Long studentId,
			Long semesterId) {
		super();
		this.id = id;
		this.subTotal = subTotal;
		this.total = total;
		this.percentage = percentage;
		this.grade = grade;
		this.studentId = studentId;
		this.semesterId = semesterId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Integer subTotal) {
		this.subTotal = subTotal;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Double getPercentage() {
		return percentage;
	}
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Long getSemesterId() {
		return semesterId;
	}
	public void setSemesterId(Long semesterId) {
		this.semesterId = semesterId;
	}

    
}
