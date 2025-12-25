package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.service.ResourceRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/requests")
public class ResourceRequestController {

    @Autowired
    private ResourceRequestService requestService;

    @PostMapping("/{userId}")
    public ResourceRequest createRequest(
            @PathVariable Long userId,
            @RequestBody ResourceRequest request) {
        return requestService.createRequest(userId, request);
    }

    @GetMapping("/user/{userId}")
    public List<ResourceRequest> getByUser(@PathVariable Long userId) {
        return requestService.getRequestsByUser(userId);
    }

    @PutMapping("/{requestId}/status")
    public ResourceRequest updateStatus(
            @PathVariable Long requestId,
            @RequestParam String status) {
        return requestService.updateRequestStatus(requestId, status);
    }
}
