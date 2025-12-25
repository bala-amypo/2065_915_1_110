package com.example.demo.service.impl;

import com.example.demo.entity.Resource;
import com.example.demo.entity.ResourceAllocation;
import com.example.demo.entity.ResourceRequest;
import com.example.demo.repository.ResourceAllocationRepository;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.repository.ResourceRequestRepository;
import com.example.demo.service.ResourceAllocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceAllocationServiceImpl implements ResourceAllocationService {

    private final ResourceRequestRepository reqRepo;
    private final ResourceRepository resourceRepo;
    private final ResourceAllocationRepository allocRepo;

    public ResourceAllocationServiceImpl(ResourceRequestRepository reqRepo,
                                         ResourceRepository resourceRepo,
                                         ResourceAllocationRepository allocRepo) {
        this.reqRepo = reqRepo;
        this.resourceRepo = resourceRepo;
        this.allocRepo = allocRepo;
    }

    @Override
    public ResourceAllocation autoAllocate(Long requestId) {
        ResourceRequest req = reqRepo.findById(requestId).orElseThrow(() -> new RuntimeException("Request not found"));
        List<Resource> resources = resourceRepo.findByResourceType(req.getResourceType());
        if (resources.isEmpty()) throw new RuntimeException("No resources available");
        ResourceAllocation allocation = new ResourceAllocation();
        allocation.setRequest(req);
        allocation.setResource(resources.get(0));
        allocation.setAllocatedAt(java.time.LocalDateTime.now());
        return allocRepo.save(allocation);
    }

    @Override
    public List<ResourceAllocation> getAllAllocations() {
        return allocRepo.findAll();
    }
}
