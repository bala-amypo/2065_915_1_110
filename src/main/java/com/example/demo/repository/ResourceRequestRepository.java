package com.example.demo.repository;

import com.example.demo.entity.ResourceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ResourceRequestRepository extends JpaRepository<ResourceRequest, Long> {

    // 🔥 THIS FIXES YOUR TEST FAILURE
    List<ResourceRequest> findByRequestedBy_Id(long userId);

    List<ResourceRequest> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);
}
