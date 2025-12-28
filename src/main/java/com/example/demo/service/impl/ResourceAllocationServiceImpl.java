package com.example.demo.service.impl;

import com.example.demo.entity.Resource;
import com.example.demo.entity.ResourceAllocation;
import com.example.demo.entity.ResourceRequest;
import com.example.demo.exception.ResourceNotFoundException;
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
        ResourceRequest request = reqRepo.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found"));
        
        List<Resource> availableResources = resourceRepo.findByResourceType(request.getResourceType());
        if (availableResources.isEmpty()) {
            throw new RuntimeException("No resources available for allocation");
        }
        
        Resource resource = availableResources.get(0);
        ResourceAllocation allocation = new ResourceAllocation(resource, request, false, null);
        return allocRepo.save(allocation);
    }
    
    @Override
    public ResourceAllocation getAllocation(Long id) {
        return allocRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Allocation not found"));
    }
    
    @Override
    public List<ResourceAllocation> getAllAllocations() {
        return allocRepo.findAll();
    }
}