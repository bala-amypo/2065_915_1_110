package com.example.demo.service.impl;

import com.example.demo.entity.Resource;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.service.ResourceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;

    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public Resource createResource(Resource resource) {
        if (resource.getResourceName() == null || resource.getResourceName().isEmpty()) {
            throw new RuntimeException("Resource name is required");
        }
        if (resource.getResourceType() == null || resource.getResourceType().isEmpty()) {
            throw new RuntimeException("Resource type is required");
        }
        if (resource.getCapacity() == null || resource.getCapacity() <= 0) {
            throw new RuntimeException("Resource capacity must be positive");
        }
        return resourceRepository.save(resource);
    }

    @Override
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }
}
