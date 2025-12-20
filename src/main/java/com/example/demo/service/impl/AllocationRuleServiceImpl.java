package com.example.demo.service.impl;

import com.example.demo.entity.AllocationRule;
import com.example.demo.repository.AllocationRuleRepository;
import com.example.demo.service.AllocationRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationRuleServiceImpl implements AllocationRuleService {

    private final AllocationRuleRepository allocationRuleRepository;

    public AllocationRuleServiceImpl(AllocationRuleRepository allocationRuleRepository) {
        this.allocationRuleRepository = allocationRuleRepository;
    }

    @Override
    public AllocationRule createRule(AllocationRule rule) {
        if (allocationRuleRepository.existsByRuleName(rule.getRuleName())) {
            throw new RuntimeException("Rule already exists");
        }
        return allocationRuleRepository.save(rule);
    }

    @Override
    public AllocationRule getRule(Long id) {
        return allocationRuleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));
    }

    @Override
    public List<AllocationRule> getAllRules() {
        return allocationRuleRepository.findAll();
    }
}
