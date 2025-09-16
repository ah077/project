package com.fsd.project.dto;

public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private String role; 
    private String rgNo; 
    private String staffRole; 

    
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
    public String getRgNo() { return rgNo; }
    public String getStaffRole() { return staffRole; } 
}