package com.fsd.project.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rgNo;
    private String name;
    private String contact;
    @Column(unique = true, nullable = false)
    private String email;
    private String gender;
    private LocalDate dob;

    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "semester_id")
    private Semester semester;

    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany
    @JoinTable(
        name = "student_subject",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Subject> subjects = new HashSet<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ExamResult> examResults = new HashSet<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FinalResult> finalResults = new HashSet<>();
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // ✅ FIX: Added nullable = true to allow a Student record
    // to exist without a matching User login.
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true)
    private User user;
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
    
	public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    
}