package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "resource_requests")
public class ResourceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resourceType;

    @ManyToOne
    private User requestedBy;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @NotBlank
    private String purpose;

    // PENDING / APPROVED / REJECTED
    private String status;

    @OneToOne(mappedBy = "request")
    private ResourceAllocation allocation;

    public ResourceRequest() {
    }

    public ResourceRequest(String resourceType, User requestedBy,
                           LocalDateTime startTime, LocalDateTime endTime,
                           String purpose, String status) {
        this.resourceType = resourceType;
        this.requestedBy = requestedBy;
        this.startTime = startTime;
        this.endTime = endTime;
        this.purpose = purpose;
        this.status = status;
    }

    @PrePersist
    void validateAndSetDefaults() {
        if (status == null) {
            status = "PENDING";
        }
        if (startTime != null && endTime != null && !startTime.isBefore(endTime)) {
            throw new IllegalArgumentException("startTime must be before endTime");
        }
    }

    public Long getId() {
        return id;
    }

    public User getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(User requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getStatus() {
        return status;
    }
}
