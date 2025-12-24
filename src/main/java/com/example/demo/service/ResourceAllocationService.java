package com.example.demo.service;

import com.example.demo.entity.ResourceAllocation;
import java.util.List;

public interface ResourceAllocationService {

    ResourceAllocation createAllocation(ResourceAllocation allocation);

    ResourceAllocation getAllocationById(Long id);

    List<ResourceAllocation> getAllAllocations();
}
