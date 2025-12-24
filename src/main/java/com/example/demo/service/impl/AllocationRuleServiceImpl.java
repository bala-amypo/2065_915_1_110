package com.example.demo.service.impl;

import com.example.demo.entity.AllocationRule;
import com.example.demo.repository.AllocationRuleRepository;
import com.example.demo.service.AllocationRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationRuleServiceImpl implements AllocationRuleService {

    @Autowired
    private AllocationRuleRepository allocationRuleRepository;

    @Override
    public AllocationRule createRule(AllocationRule rule) {
        return allocationRuleRepository.save(rule);
    }

    @Override
    public AllocationRule getRuleById(Long id) {
        return allocationRuleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Allocation Rule not found"));
    }

    @Override
    public List<AllocationRule> getAllRules() {
        return allocationRuleRepository.findAll();
    }
}
