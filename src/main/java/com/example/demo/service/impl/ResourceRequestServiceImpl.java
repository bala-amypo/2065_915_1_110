package com.example.demo.service.impl;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.repository.ResourceRequestRepository;
import com.example.demo.service.ResourceRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceRequestServiceImpl implements ResourceRequestService {

    @Autowired
    private ResourceRequestRepository resourceRequestRepository;

    @Override
    public ResourceRequest createRequest(ResourceRequest request) {
        return resourceRequestRepository.save(request);
    }

    @Override
    public ResourceRequest getRequestById(Long id) {
        return resourceRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));
    }

    @Override
    public List<ResourceRequest> getAllRequests() {
        return resourceRequestRepository.findAll();
    }
}
