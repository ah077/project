package com.fsd.project.dto;

public class StaffDTO {
    private Long id;
    private String name;
    private String role;
    private String phone;
    private String address;
    private String email; 
    private String departmentName;

    private Long departmentId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getEmail() { return email; } // ✅ ADDED GETTER
    public void setEmail(String email) { this.email = email; } // ✅ ADDED SETTER
    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }
    public Long getDepartmentId() { return departmentId; }
    public void setDepartmentId(Long departmentId) { this.departmentId = departmentId; }
}