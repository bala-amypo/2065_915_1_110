package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ResourceRequestRepository;
import com.example.demo.service.ResourceRequestService;

@Service
public class ResourceRequestServiceImpl implements ResourceRequestService {

    @Autowired
    private ResourceRequestRepository requestRepository;

    @Override
    public ResourceRequest saveRequest(ResourceRequest request) {
        return requestRepository.save(request);
    }

    @Override
    public ResourceRequest getRequest(Long id) {
        return requestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found with id " + id));
    }

    @Override
    public List<ResourceRequest> getAllRequests() {
        return requestRepository.findAll();
    }
}
