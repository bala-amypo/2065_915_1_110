package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ResourceAllocation;
import com.example.demo.service.ResourceAllocationService;

@RestController
@RequestMapping("/allocations")
public class ResourceAllocationController {

    @Autowired
    private ResourceAllocationService allocationService;

    @PostMapping
    public ResourceAllocation allocate(@RequestBody ResourceAllocation allocation) {
        return allocationService.saveAllocation(allocation);
    }

    @GetMapping
    public List<ResourceAllocation> getAllAllocations() {
        return allocationService.getAllAllocations();
    }

    @GetMapping("/{id}")
    public ResourceAllocation getAllocation(@PathVariable Long id) {
        return allocationService.getAllocationById(id);
    }
}
