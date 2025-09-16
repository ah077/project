package com.fsd.project.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String name;
    private Integer credits;
    private Integer duration;

    @ManyToMany(mappedBy = "subjects")
    private Set<Student> students = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "subject_assessment",
        joinColumns = @JoinColumn(name = "subject_id"),
        inverseJoinColumns = @JoinColumn(name = "assessment_id")
    )
    private Set<Assessment> assessments = new HashSet<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getCredits() { return credits; }
    public void setCredits(Integer credits) { this.credits = credits; }
    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }
    public Set<Student> getStudents() { return students; }
    public void setStudents(Set<Student> students) { this.students = students; }
    public Set<Assessment> getAssessments() { return assessments; }
    public void setAssessments(Set<Assessment> assessments) { this.assessments = assessments; }
}