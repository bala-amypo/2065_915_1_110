package com.example.demo.entity;

import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String fullName;
    
    @Column(unique = true)
    private String email;
    
    private String password;
    
    private String role = "USER";
    
    private LocalDateTime createdAt;
    
    public User() {
        this.createdAt = LocalDateTime.now();
    }
    
    public User(String fullName, String email, String password, String role) {
        this();
        this.fullName = fullName;
        this.email = email;
        setPassword(password);
        this.role = role != null ? role : "USER";
    }
    
    @PrePersist
    protected void onCreate() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
        if (role == null) {
            role = "USER";
        }
    }
    
    public void setPassword(String password) {
        if (password != null && !password.startsWith("$2a$")) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            this.password = encoder.encode(password);
        } else {
            this.password = password;
        }
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPassword() { return password; }
    
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}