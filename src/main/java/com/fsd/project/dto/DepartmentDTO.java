package com.fsd.project.dto;

public class DepartmentDTO {
    private Long id;
    private String name;
    private Integer intake;
    private String hod;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getIntake() { return intake; }
    public void setIntake(Integer intake) { this.intake = intake; }
    public String getHod() { return hod; }
    public void setHod(String hod) { this.hod = hod; }
}