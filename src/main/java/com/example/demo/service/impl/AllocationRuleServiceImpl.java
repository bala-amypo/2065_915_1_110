package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AllocationRule;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AllocationRuleRepository;
import com.example.demo.service.AllocationRuleService;

@Service
public class AllocationRuleServiceImpl implements AllocationRuleService {

    @Autowired
    private AllocationRuleRepository ruleRepository;

    @Override
    public AllocationRule saveRule(AllocationRule rule) {
        return ruleRepository.save(rule);
    }

    @Override
    public AllocationRule getRule(Long id) {
        return ruleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found with id " + id));
    }

    @Override
    public List<AllocationRule> getAllRules() {
        return ruleRepository.findAll();
    }
}
