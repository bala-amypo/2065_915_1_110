package com.example.demo.service;

import com.example.demo.entity.ResourceRequest;
import java.util.List;

public interface ResourceRequestService {

    Resource createRequest(ResourceRequest request);

    ResourceRequest getRequestById(Long id);

    List<ResourceRequest> getAllRequests();
}
