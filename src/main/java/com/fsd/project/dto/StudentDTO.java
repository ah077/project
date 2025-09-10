package com.fsd.project.dto;

import java.time.LocalDate;
import java.util.List;

public class StudentDTO {
    private Long id;
    private String rgNo;
    private String name;
    private String contact;
    private String email;
    private String gender;
    private LocalDate dob;
    private Long semesterId;
    private Long departmentId;
    private List<Long> subjectIds;
	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentDTO(Long id, String rgNo, String name, String contact, String email, String gender, LocalDate dob,
			Long semesterId, Long departmentId, List<Long> subjectIds) {
		super();
		this.id = id;
		this.rgNo = rgNo;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.gender = gender;
		this.dob = dob;
		this.semesterId = semesterId;
		this.departmentId = departmentId;
		this.subjectIds = subjectIds;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRgNo() {
		return rgNo;
	}
	public void setRgNo(String rgNo) {
		this.rgNo = rgNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Long getSemesterId() {
		return semesterId;
	}
	public void setSemesterId(Long semesterId) {
		this.semesterId = semesterId;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public List<Long> getSubjectIds() {
		return subjectIds;
	}
	public void setSubjectIds(List<Long> subjectIds) {
		this.subjectIds = subjectIds;
	}
    
    
}
