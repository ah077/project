package com.fsd.project.dto;

import java.util.List;

public class SubjectDTO {
    private Long id;
    private String code;
    private String name;
    private Integer credits;
    private Integer duration;
    private List<Long> assessmentIds;
	public SubjectDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SubjectDTO(Long id, String code, String name, Integer credits, Integer duration, List<Long> assessmentIds) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.credits = credits;
		this.duration = duration;
		this.assessmentIds = assessmentIds;
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
	public List<Long> getAssessmentIds() {
		return assessmentIds;
	}
	public void setAssessmentIds(List<Long> assessmentIds) {
		this.assessmentIds = assessmentIds;
	}
    
    
}
