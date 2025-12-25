package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.entity.Resource;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.service.ResourceService;

import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepo;

    public ResourceServiceImpl(ResourceRepository resourceRepo) {
        this.resourceRepo = resourceRepo;
    }

    @Override
    public Resource createResource(Resource resource) {
        if (resource.getResourceName() == null ||
            resource.getResourceType() == null ||
            resource.getCapacity() <= 0) {
            throw new RuntimeException("Invalid resource");
        }

        if (resourceRepo.existsByResourceName(resource.getResourceName())) {
            throw new RuntimeException("Resource already exists");
        }

        return resourceRepo.save(resource);
    }

    @Override
    public List<Resource> getAllResources() {
        return resourceRepo.findAll();
    }
}
