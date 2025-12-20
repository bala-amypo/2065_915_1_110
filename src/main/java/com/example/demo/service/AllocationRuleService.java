package com.example.demo.service;

import com.example.demo.entity.AllocationRule;
import java.util.List;

public interface AllocationRuleService {
    AllocationRule createRule(AllocationRule rule);
    AllocationRule getRule(Long id);
    List<AllocationRule> getAllRules();
}



package com.example.demo.service;

import com.example.demo.entity.AllocationRule;
import java.util.List;

public interface AllocationRuleService {

    AllocationRule createRule(AllocationRule rule); // Save new allocation rule

    List<AllocationRule> getAllRules(); // Get all rules

    AllocationRule getRuleById(Long id); // Get a single rule by ID

    void deleteRule(Long id); // Delete rule by ID
}
