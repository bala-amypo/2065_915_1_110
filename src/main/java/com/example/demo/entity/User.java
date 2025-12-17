package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private Stringe email;
    private String role;
    private LocalDateTime createdAt;
   
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

}
