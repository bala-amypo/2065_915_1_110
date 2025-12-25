package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.AllocationRule;
import com.example.demo.service.AllocationRuleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rules")
public class AllocationRuleController {

    @Autowired
    private AllocationRuleService ruleService;

    @PostMapping
    public AllocationRule create(@RequestBody AllocationRule rule) {
        return ruleService.createRule(rule);
    }

    @GetMapping("/{id}")
    public AllocationRule get(@PathVariable Long id) {
        return ruleService.getRule(id);
    }

    @GetMapping
    public List<AllocationRule> getAll() {
        return ruleService.getAllRules();
    }
}
