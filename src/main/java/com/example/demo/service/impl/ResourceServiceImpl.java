package com.example.demo.service.impl;

import com.example.demo.entity.Resource;
import com.example.demo.repository.ResourceRepository;
import com.example.demo.service.ResourceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepo;

    public ResourceServiceImpl(ResourceRepository resourceRepo) {
        this.resourceRepo = resourceRepo;
    }

    @Override
    public Resource createResource(Resource resource) {
        if (resourceRepo.existsByResourceName(resource.getResourceName())) {
            throw new IllegalArgumentException("Resource already exists");
        }
        return resourceRepo.save(resource);
    }

    @Override
    public Resource getResource(Long id) {
        return resourceRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Resource not found"));
    }

    @Override
    public List<Resource> getAllResources() {
        return resourceRepo.findAll();
    }
}
