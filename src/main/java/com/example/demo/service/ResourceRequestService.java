package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.ResourceRequest;

public interface ResourceRequestService {

    ResourceRequest saveRequest(ResourceRequest request);

    ResourceRequest getRequest(Long id);

    List<ResourceRequest> getAllRequests();
}
