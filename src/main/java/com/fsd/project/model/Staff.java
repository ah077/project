package com.fsd.project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String role;
    private String phone;
    private String address;
    @Column(unique = true, nullable = false)
    private String email; // Add the email field

    @ManyToOne(fetch = FetchType.LAZY) // ✅ CLEANUP: Reverted to LAZY
    @JoinColumn(name = "department_id")
    private Department department;

    

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // ✅ FIX: Added nullable = true.
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true)
    private User user;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    
}