package com.example.demo.service.impl;

import com.example.demo.entity.ResourceRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.ResourceRequestRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ResourceRequestService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ResourceRequestServiceImpl implements ResourceRequestService {

    private final ResourceRequestRepository requestRepository;
    private final UserRepository userRepository;

    public ResourceRequestServiceImpl(ResourceRequestRepository requestRepository, UserRepository userRepository) {
        this.requestRepository = requestRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResourceRequest createRequest(Long userId, ResourceRequest request) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) throw new RuntimeException("User not found");
        request.setRequestedBy(userOpt.get());
        return requestRepository.save(request);
    }

    @Override
    public List<ResourceRequest> getRequestsByUser(Long userId) {
        return requestRepository.findByRequestedBy_Id(userId);
    }

    @Override
    public ResourceRequest updateRequestStatus(Long requestId, String status) {
        ResourceRequest rr = requestRepository.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));
        rr.setStatus(status);
        return requestRepository.save(rr);
    }
}
