package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.ResourceAllocation;

public interface ResourceAllocationService {

    ResourceAllocation saveAllocation(ResourceAllocation allocation);

    ResourceAllocation getAllocation(Long id);

    List<ResourceAllocation> getAllAllocations();
}
