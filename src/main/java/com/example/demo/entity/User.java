package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;

    @Email(message = "Invalid email format")
    @Column(unique = true, nullable = false)
    private Stringe email;
    private String role;
    private LocalDateTime createdAt;
   
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public Stringe getEmail() {
        return email;
    }
    public void setEmail(Stringe email) {
        this.email = email;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public User(Long id, String fullName, Stringe email, String role, LocalDateTime createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
    }
    public User() {
    }
    

}
