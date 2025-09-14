package com.fsd.project.dto;

public class SemesterDTO {
    private Long id;
    private String sno;
    private String stage;
    private Integer endYear;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSno() { return sno; }
    public void setSno(String sno) { this.sno = sno; }
    public String getStage() { return stage; }
    public void setStage(String stage) { this.stage = stage; }
    public Integer getEndYear() { return endYear; }
    public void setEndYear(Integer endYear) { this.endYear = endYear; }
}