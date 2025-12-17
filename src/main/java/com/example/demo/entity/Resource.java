package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

public class Resource {
    private Long id;
    private String resourceName;
    private String resourceType;
    private int capacity;
    private String location;
    private LocalDateTime createdAt;

}
