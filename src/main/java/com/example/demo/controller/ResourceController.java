package com.example.demo.controller;

import com.example.demo.entity.Resource;
import com.example.demo.dto.ApiResponse;
import com.example.demo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    private final ResourceService resourceService;

    @Autowired
    public ResourceController(ResourceService resourceService){
        this.resourceService = resourceService;
    }

    @PostMapping
    public ApiResponse createResource(@RequestBody Resource resource){
        Resource created = resourceService.createResource(resource);
        return new ApiResponse(true, "Resource created successfully", created);
    }

    @GetMapping
    public List<Resource> getAllResources(){
        return resourceService.getAllResources();
    }

    @GetMapping("/{id}")
    public Resource getResource(@PathVariable Long id){
        return resourceService.getResource(id);
    }
}
