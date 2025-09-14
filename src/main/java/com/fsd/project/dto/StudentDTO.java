package com.fsd.project.dto;

import java.time.LocalDate;
import java.util.List;

// This DTO is used for both creating/updating and for API responses.
public class StudentDTO {
    // For Responses
    private Long id;
    private String rgNo;
    private String name;
    private String contact;
    private String email;
    private String gender;
    private LocalDate dob;
    private String departmentName;
    private String semesterInfo;

    // For Requests (Creating/Updating)
    private Long departmentId;
    private Long semesterId;
    private List<Long> subjectIds;

    // Getters and Setters for all fields...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRgNo() { return rgNo; }
    public void setRgNo(String rgNo) { this.rgNo = rgNo; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }
    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }
    public String getSemesterInfo() { return semesterInfo; }
    public void setSemesterInfo(String semesterInfo) { this.semesterInfo = semesterInfo; }
    public Long getDepartmentId() { return departmentId; }
    public void setDepartmentId(Long departmentId) { this.departmentId = departmentId; }
    public Long getSemesterId() { return semesterId; }
    public void setSemesterId(Long semesterId) { this.semesterId = semesterId; }
    public List<Long> getSubjectIds() { return subjectIds; }
    public void setSubjectIds(List<Long> subjectIds) { this.subjectIds = subjectIds; }
}