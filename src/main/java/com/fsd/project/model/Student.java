package com.fsd.project.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "students")
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rgNo;
    private String name;
    private String contact;
    private String email;
    private String gender;
    private LocalDate dob;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "semester_id")
    @JsonBackReference
    private Semester semester;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

    // student takes many subjects, subject can be taken by many students -> M:N
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "student_subject",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Subject> subjects;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    @JsonManagedReference("student-examresult") // Named reference
    private Set<ExamResult> examResults;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    @JsonManagedReference("student-finalresult") // New named reference
    private Set<FinalResult> finalResults;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Long id, String rgNo, String name, String contact, String email, String gender,
			Semester semester, Department department,LocalDate dob, Set<Subject> subjects, Set<ExamResult> examResults,
			Set<FinalResult> finalResults) {
		super();
		this.id = id;
		this.rgNo = rgNo;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.gender = gender;
		this.dob = dob;
		this.semester = semester;
		this.department = department;
		this.subjects = subjects;
		this.examResults = examResults;
		this.finalResults = finalResults;
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

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Set<ExamResult> getExamResults() {
		return examResults;
	}

	public void setExamResults(Set<ExamResult> examResults) {
		this.examResults = examResults;
	}

	public Set<FinalResult> getFinalResults() {
		return finalResults;
	}

	public void setFinalResults(Set<FinalResult> finalResults) {
		this.finalResults = finalResults;
	}

	

    
}
