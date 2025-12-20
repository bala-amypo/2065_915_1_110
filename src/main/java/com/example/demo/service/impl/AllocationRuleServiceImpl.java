// AllocationRuleServiceImpl.java
package com.example.demo.service.impl;

import com.example.demo.entity.AllocationRule;
import com.example.demo.repository.AllocationRuleRepository;
import com.example.demo.service.AllocationRuleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
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
}
