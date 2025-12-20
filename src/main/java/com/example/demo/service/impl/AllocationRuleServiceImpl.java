package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.AllocationRule;
import com.example.demo.repository.AllocationRuleRepository;
import com.example.demo.service.AllocationRuleService;
import java.util.List;
import java.util.Optional;

@Service
public class AllocationRuleServiceImpl implements AllocationRuleService {

    @Autowired
    private AllocationRuleRepository allocationRuleRepository;

    @Override
    public AllocationRule createRule(AllocationRule rule) {
        rule.setCreatedAt(java.time.LocalDateTime.now());
        return allocationRuleRepository.save(rule);
    }

    @Override
    public List<AllocationRule> getAllRules() {
        return allocationRuleRepository.findAll();
    }

    @Override
    public AllocationRule getRuleById(Long id) {
        Optional<AllocationRule> rule = allocationRuleRepository.findById(id);
        return rule.orElseThrow(() -> new RuntimeException("Rule not found with id: " + id));
    }

    @Override
    public void deleteRule(Long id) {
        allocationRuleRepository.deleteById(id);
    }
}
