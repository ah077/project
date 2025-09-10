package com.fsd.project.dto;

public class SemesterDTO {
    private Long id;
    private Integer sno;
    private String stage;
    private String endYear;
	public SemesterDTO(Long id, Integer sno, String stage, String endYear) {
		super();
		this.id = id;
		this.sno = sno;
		this.stage = stage;
		this.endYear = endYear;
	}
	public SemesterDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public String getEndYear() {
		return endYear;
	}
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}

    
}
