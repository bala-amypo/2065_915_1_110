package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class User {
    
    private Long id;
    private String fullName;
    private Stringe email;
    private String role;
    private LocalDateTime createdAt;


}
