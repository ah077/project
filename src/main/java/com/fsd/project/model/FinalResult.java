package com.fsd.project.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "final_results")
public class FinalResult {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer subTotal;
    private Integer total;
    private Double percentage;
    private String grade;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference("student-finalresult") // Matches name in Student.java
    private Student student;

    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;

    @OneToMany(mappedBy = "finalResult")
    @JsonManagedReference("finalresult-examresult") // Named reference
    private Set<ExamResult> includedExamResults;

	public FinalResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FinalResult(Long id, Integer subTotal, Integer total, Double percentage, String grade, Student student,
			Semester semester, Set<ExamResult> includedExamResults) {
		super();
		this.id = id;
		this.subTotal = subTotal;
		this.total = total;
		this.percentage = percentage;
		this.grade = grade;
		this.student = student;
		this.semester = semester;
		this.includedExamResults = includedExamResults;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Integer subTotal) {
		this.subTotal = subTotal;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public Set<ExamResult> getIncludedExamResults() {
		return includedExamResults;
	}

	public void setIncludedExamResults(Set<ExamResult> includedExamResults) {
		this.includedExamResults = includedExamResults;
	}

    
}
