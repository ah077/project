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
@Entity
@Table(name = "exam_results")
public class ExamResult {
    public ExamResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer marks;
    private String grade;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "exam_id")
    @JsonBackReference("exam-examresult") // Matches name in Exam.java
    private Exam exam;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    @JsonBackReference("student-examresult") // Matches name in Student.java
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "final_result_id")
    @JsonBackReference("finalresult-examresult") // Matches name in FinalResult.java
    private FinalResult finalResult;

	public ExamResult(Long id, Integer marks, String grade, Exam exam, Student student, FinalResult finalResult) {
		super();
		this.id = id;
		this.marks = marks;
		this.grade = grade;
		this.exam = exam;
		this.student = student;
		this.finalResult = finalResult;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public FinalResult getFinalResult() {
		return finalResult;
	}

	public void setFinalResult(FinalResult finalResult) {
		this.finalResult = finalResult;
	}

   
}
