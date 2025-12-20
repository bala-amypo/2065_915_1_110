package com.example.demo.service.impl;

import com.example.demo.entity.AllocationRule;
import com.example.demo.repository.AllocationRuleRepository;
import com.example.demo.service.AllocationRuleService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service   // 🔥 THIS IS THE MOST IMPORTANT LINE
public class AllocationRuleServiceImpl implements AllocationRuleService {

    private final AllocationRuleRepository repository;

    public AllocationRuleServiceImpl(AllocationRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public AllocationRule createRule(AllocationRule rule) {
        return repository.save(rule);
    }

    @Override
    public List<AllocationRule> getAllRules() {
        return repository.findAll();
    }

    @Override
    public AllocationRule getRuleById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));
    }

    @Override
    public AllocationRule updateRule(Long id, AllocationRule rule) {
        AllocationRule existing = getRuleById(id);
        existing.setRuleName(rule.getRuleName());
        existing.setRuleType(rule.getRuleType());
        existing.setPriorityWeight(rule.getPriorityWeight());
        return repository.save(existing);
    }

    @Override
    public void deleteRule(Long id) {
        repository.deleteById(id);
    }
}
