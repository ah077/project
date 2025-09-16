package com.fsd.project.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Calendar;

@Entity
public class VerificationToken {

    private static final int EXPIRATION = 60 * 24; 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    private Date expiryDate;

    public VerificationToken() {
        super();
    }

    public VerificationToken(String token, User user) {
        super();
        this.token = token;
        this.user = user;
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }
    
    private Date calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }
    
    // Getters and Setters...
    public Long getId() { return id; }
    public String getToken() { return token; }
    public User getUser() { return user; }
    public Date getExpiryDate() { return expiryDate; }
}