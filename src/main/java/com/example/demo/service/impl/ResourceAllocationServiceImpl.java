package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ResourceAllocation;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ResourceAllocationRepository;
import com.example.demo.service.ResourceAllocationService;

@Service
public class ResourceAllocationServiceImpl implements ResourceAllocationService {

    @Autowired
    private ResourceAllocationRepository allocationRepository;

    @Override
    public ResourceAllocation saveAllocation(ResourceAllocation allocation) {
        return allocationRepository.save(allocation);
    }

    @Override
    public ResourceAllocation getAllocation(Long id) {
        return allocationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Allocation not found with id " + id));
    }

    @Override
    public List<ResourceAllocation> getAllAllocations() {
        return allocationRepository.findAll();
    }
}
