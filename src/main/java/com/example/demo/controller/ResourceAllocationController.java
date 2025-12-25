package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.ResourceAllocation;
import com.example.demo.service.ResourceAllocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/allocations")
public class ResourceAllocationController {

    @Autowired
    private ResourceAllocationService allocationService;

    @PostMapping("/{requestId}")
    public ResourceAllocation allocate(@PathVariable Long requestId) {
        return allocationService.autoAllocate(requestId);
    }

    @GetMapping
    public List<ResourceAllocation> getAll() {
        return allocationService.getAllAllocations();
    }
}
