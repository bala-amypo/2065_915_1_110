package com.example.demo.service.impl;

import com.example.demo.entity.ResourceAllocation;
import com.example.demo.repository.ResourceAllocationRepository;
import com.example.demo.service.ResourceAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceAllocationServiceImpl implements ResourceAllocationService {

    @Autowired
    private ResourceAllocationRepository resourceAllocationRepository;

    @Override
    public ResourceAllocation createAllocation(ResourceAllocation allocation) {
        return resourceAllocationRepository.save(allocation);
    }

    @Override
    public ResourceAllocation getAllocationById(Long id) {
        return resourceAllocationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Allocation not found"));
    }

    @Override
    public List<ResourceAllocation> getAllAllocations() {
        return resourceAllocationRepository.findAll();
    }
}
