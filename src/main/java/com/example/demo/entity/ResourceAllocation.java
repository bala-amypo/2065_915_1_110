package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "resource_allocations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceAllocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private ResourceRequest request;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    private LocalDateTime allocatedAt = LocalDateTime.now();

    private String notes;
}
