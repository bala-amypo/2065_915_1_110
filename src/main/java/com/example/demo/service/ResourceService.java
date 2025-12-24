package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Resource;

public interface ResourceService {

    Resource saveResource(Resource resource);

    Resource getResource(Long id);

    List<Resource> getAllResources();
}
