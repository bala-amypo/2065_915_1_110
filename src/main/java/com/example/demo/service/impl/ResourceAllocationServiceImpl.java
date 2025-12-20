package com.example.demo.service.impl;

import com.example.demo.entity.Resource;
import com.example.demo.entity.ResourceAllocation;
import com.example.demo.entity.ResourceRequest;
import com.example.demo.repository.ResourceAllocationRepository;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.repository.ResourceRequestRepository;
import com.example.demo.service.ResourceAllocationService;

import java.util.List;

public class ResourceAllocationServiceImpl implements ResourceAllocationService {

    private final ResourceAllocationRepository allocationRepository;
    private final ResourceRepository resourceRepository;
    private final ResourceRequestRepository requestRepository;

    public ResourceAllocationServiceImpl(ResourceAllocationRepository allocationRepository,
                                         ResourceRepository resourceRepository,
                                         ResourceRequestRepository requestRepository) {
        this.allocationRepository = allocationRepository;
        this.resourceRepository = resourceRepository;
        this.requestRepository = requestRepository;
    }

    @Override
    public ResourceAllocation autoAllocate(Long requestId) {
        ResourceRequest request = requestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        List<Resource> resources =
                resourceRepository.findByResourceType(request.getResourceType());

        if (resources.isEmpty()) {
            throw new RuntimeException("No resource available");
        }

        ResourceAllocation allocation = new ResourceAllocation();
        allocation.setRequest(request);
        allocation.setResource(resources.get(0));
        allocation.setConflictFlag(false);

        request.setStatus("APPROVED");

        return allocationRepository.save(allocation);
    }

    @Override
    public ResourceAllocation getAllocation(Long id) {
        return allocationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Allocation not found"));
    }

    @Override
    public List<ResourceAllocation> getAllAllocations() {
        return allocationRepository.findAll();
    }
}
