package com.example.demo.service;

import com.example.demo.entity.AllocationRule;
import java.util.List;

public interface AllocationRuleService {

    AllocationRule createRule(AllocationRule rule);

    List<AllocationRule> getAllRules();

    AllocationRule getRuleById(Long id);

    AllocationRule updateRule(Long id, AllocationRule rule);

    void deleteRule(Long id);
}
