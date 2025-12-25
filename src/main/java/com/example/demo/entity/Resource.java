package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "resources")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String resourceName;

    @Column(nullable = false)
    private String resourceType;

    @Column(nullable = false)
    private Integer capacity;

    public Resource(String resourceName, String resourceType, Integer capacity) {
        this.resourceName = resourceName;
        this.resourceType = resourceType;
        this.capacity = capacity;
    }
}
