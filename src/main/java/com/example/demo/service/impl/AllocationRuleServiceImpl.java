package com.example.demo.service.impl;

import com.example.demo.entity.AllocationRule;
import com.example.demo.repository.AllocationRuleRepository;
import com.example.demo.service.AllocationRuleService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AllocationRuleServiceImpl implements AllocationRuleService {

    private final AllocationRuleRepository ruleRepository;

    public AllocationRuleServiceImpl(AllocationRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public AllocationRule createRule(AllocationRule rule) {
        if (ruleRepository.existsByRuleName(rule.getRuleName())) {
            throw new IllegalArgumentException("Rule with name already exists");
        }
        if (rule.getPriorityWeight() == null || rule.getPriorityWeight() < 0) {
            throw new IllegalArgumentException("Priority weight must be >= 0");
        }
        rule.setCreatedAt(LocalDateTime.now());
        return ruleRepository.save(rule);
    }

    @Override
    public AllocationRule getRule(Long id) {
        return ruleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Allocation rule not found"));
    }

    @Override
    public List<AllocationRule> getAllRules() {
        return ruleRepository.findAll();
    }
}
