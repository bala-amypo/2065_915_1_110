package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

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

    private String purpose;

    private String resourceType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User requestedBy;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private String status = "PENDING";
}
