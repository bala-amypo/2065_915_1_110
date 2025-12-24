package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.service.ResourceRequestService;

@RestController
@RequestMapping("/resource-requests")
public class ResourceRequestController {

    @Autowired
    private ResourceRequestService requestService;

    @PostMapping
    public ResourceRequest createRequest(@RequestBody ResourceRequest request) {
        return requestService.saveRequest(request);
    }

    @GetMapping
    public List<ResourceRequest> getAllRequests() {
        return requestService.getAllRequests();
    }

    @GetMapping("/{id}")
    public ResourceRequest getRequest(@PathVariable Long id) {
        return requestService.getRequestById(id);
    }
}
