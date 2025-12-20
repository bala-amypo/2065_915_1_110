package com.example.demo.service;

import com.example.demo.entity.ResourceRequest;
import java.util.List;

public interface ResourceRequestService {

    ResourceRequest createRequest(Long userid, ResourceRequest request);

    List<ResourceRequest> getRequestsByUser(Long userid);

    ResourceRequest getRequest(Long id);

    ResourceRequest updateRequestStatus(Long requestId, String status);
}
