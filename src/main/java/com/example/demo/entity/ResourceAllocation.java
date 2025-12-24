package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "resource_allocations")
public class ResourceAllocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "resource_request_id")
    @NotNull
    private ResourceRequest resourceRequest;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    @NotNull
    private Resource resource;

    @NotNull
    private Date allocationDate;

    public ResourceAllocation() {}

    public ResourceAllocation(ResourceRequest resourceRequest, Resource resource, Date allocationDate) {
        this.resourceRequest = resourceRequest;
        this.resource = resource;
        this.allocationDate = allocationDate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ResourceRequest getResourceRequest() { return resourceRequest; }
    public void setResourceRequest(ResourceRequest resourceRequest) { this.resourceRequest = resourceRequest; }

    public Resource getResource() { return resource; }
    public void setResource(Resource resource) { this.resource = resource; }

    public Date getAllocationDate() { return allocationDate; }
    public void setAllocationDate(Date allocationDate) { this.allocationDate = allocationDate; }
}
