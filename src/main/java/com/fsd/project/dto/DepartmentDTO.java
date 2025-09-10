package com.fsd.project.dto;

import java.util.List;

public class DepartmentDTO {
    private Long id;
    private String name;
    private Integer intake;
    private String hod;
    private List<Long> staffIds;
	public DepartmentDTO() {
		super();
		// TODO Auto-generated constructor stub
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
	public Integer getIntake() {
		return intake;
	}
	public void setIntake(Integer intake) {
		this.intake = intake;
	}
	public String getHod() {
		return hod;
	}
	public void setHod(String hod) {
		this.hod = hod;
	}
	public List<Long> getStaffIds() {
		return staffIds;
	}
	public void setStaffIds(List<Long> staffIds) {
		this.staffIds = staffIds;
	}
	public DepartmentDTO(Long id, String name, Integer intake, String hod, List<Long> staffIds) {
		super();
		this.id = id;
		this.name = name;
		this.intake = intake;
		this.hod = hod;
		this.staffIds = staffIds;
	}

    // Getters and setters
}
