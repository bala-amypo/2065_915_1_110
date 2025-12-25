package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "resource_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resourceType;
    private String purpose;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private String status = "PENDING";

    @ManyToOne
    @JoinColumn(name = "requested_by")
    private User requestedBy;
}
