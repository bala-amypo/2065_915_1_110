package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Resource;
import com.example.demo.service.ResourceService;

@RestController
@RequestMapping("/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping
    public Resource createResource(@RequestBody Resource resource) {
        return resourceService.saveResource(resource);
    }

    @GetMapping
    public List<Resource> getAllResources() {
        return resourceService.getAllResources();
    }

    @GetMapping("/{id}")
    public Resource getResource(@PathVariable Long id) {
        return resourceService.getResourceById(id);
    }
}
