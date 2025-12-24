package com.example.demo.controller;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.service.ResourceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class ResourceRequestController {

    private final ResourceRequestService requestService;

    @Autowired
    public ResourceRequestController(ResourceRequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<ResourceRequest> createRequest(@PathVariable Long userId, @Valid @RequestBody ResourceRequest request) {
        ResourceRequest created = requestService.createRequest(userId, request);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ResourceRequest>> getRequestsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(requestService.getRequestsByUser(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceRequest> getRequest(@PathVariable Long id) {
        return ResponseEntity.ok(requestService.getRequest(id));
    }

    @PutMapping("/status/{requestId}")
    public ResponseEntity<ResourceRequest> updateRequestStatus(@PathVariable Long requestId, @RequestParam String status) {
        return ResponseEntity.ok(requestService.updateRequestStatus(requestId, status));
    }
}
