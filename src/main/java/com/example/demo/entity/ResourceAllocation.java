package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ResourceAllocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Resource resource;

    @ManyToOne
    private ResourceRequest request;

    private String notes;
    private LocalDateTime allocatedAt = LocalDateTime.now();

    public ResourceAllocation() {}

    public ResourceAllocation(Long id, Resource resource, ResourceRequest request, String notes,
                              LocalDateTime allocatedAt) {
        this.id = id;
        this.resource = resource;
        this.request = request;
        this.notes = notes;
        this.allocatedAt = allocatedAt;
    }

    public ResourceAllocation(Resource resource, ResourceRequest request, String notes) {
        this.resource = resource;
        this.request = request;
        this.notes = notes;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Resource getResource() { return resource; }
    public void setResource(Resource resource) { this.resource = resource; }
    public ResourceRequest getRequest() { return request; }
    public void setRequest(ResourceRequest request) { this.request = request; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public LocalDateTime getAllocatedAt() { return allocatedAt; }
    public void setAllocatedAt(LocalDateTime allocatedAt) { this.allocatedAt = allocatedAt; }
}
