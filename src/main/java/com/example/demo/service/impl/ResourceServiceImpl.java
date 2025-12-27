package com.example.demo.service.impl; 
 
import com.example.demo.entity.Resource; 
import com.example.demo.repository.ResourceRepository; 
import com.example.demo.service.ResourceService; 
import java.util.List; 
 
public class ResourceServiceImpl implements ResourceService { 
 
    private final ResourceRepository resourceRepo; 
 
    public ResourceServiceImpl(ResourceRepository resourceRepository) { 
        this.resourceRepo = resourceRepository; 
    } 
 
    @Override 
    public Resource createResource(Resource resource) { 
        if (resource.getResourceType() == null || resource.getCapacity() == null || resource.getCapacity() < 1) { 
            throw new IllegalArgumentException("Invalid resource data"); 
        } 
 
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