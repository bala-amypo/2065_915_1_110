package com.example.demo.service;

import com.example.demo.entity.AllocationRule;
import java.util.List;
@Service
public interface AllocationRuleService {

    AllocationRule createRule(AllocationRule rule);

    AllocationRule getRule(Long id);

    List<AllocationRule> getAllRules();
}
