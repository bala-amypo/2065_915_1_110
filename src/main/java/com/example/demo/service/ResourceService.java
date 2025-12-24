package com.example.demo.service;

import com.example.demo.entity.Resource;
import java.util.List;

public interface ResourceService {
    Resource getResource(Long id);   // must match Impl
    List<Resource> getAllResources();
    Resource createResource(Resource resource);
}
