package com.fsd.project.dto;

public class StaffDTO {
    private Long id;
    private String name;
    private String role;
    private String phone;
    private String address;
    private Long departmentId;
	public StaffDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StaffDTO(Long id, String name, String role, String phone, String address, Long departmentId) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.phone = phone;
		this.address = address;
		this.departmentId = departmentId;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

    
}
