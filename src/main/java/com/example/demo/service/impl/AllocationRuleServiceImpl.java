package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.AllocationRule;
import com.example.demo.repository.AllocationRuleRepository;
import com.example.demo.service.AllocationRuleService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service // Make Spring detect this as a bean
public class AllocationRuleServiceImpl implements AllocationRuleService {

    @Autowired
    private AllocationRuleRepository allocationRuleRepository;

    @Override
    public AllocationRule createRule(AllocationRule rule) {
        // Set createdAt before saving
        rule.setCreatedAt(LocalDateTime.now());
        return allocationRuleRepository.save(rule);
    }

    @Override
    public List<AllocationRule> getAllRules() {
        return allocationRuleRepository.findAll();
    }

    @Override
    public AllocationRule getRuleById(Long id) {
        Optional<AllocationRule> rule = allocationRuleRepository.findById(id);
        // Throw an exception if rule not found
        if (rule.isPresent()) {
            return rule.get();
        } else {
            throw new RuntimeException("AllocationRule not found with id: " + id);
        }
    }

    @Override
    public void deleteRule(Long id) {
        if (!allocationRuleRepository.existsById(id)) {
            throw new RuntimeException("Cannot delete. AllocationRule not found with id: " + id);
        }
        allocationRuleRepository.deleteById(id);
    }
}
