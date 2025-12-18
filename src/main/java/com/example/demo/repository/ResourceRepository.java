`package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

    boolean existsByResourceName(String resourceName);

    List<Resource> findByResourceType(String resourceType);
}
