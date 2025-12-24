package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.AllocationRule;
import com.example.demo.service.AllocationRuleService;

@RestController
@RequestMapping("/allocation-rules")
public class AllocationRuleController {

    @Autowired
    private AllocationRuleService allocationRuleService;

    @PostMapping
    public AllocationRule createRule(@RequestBody AllocationRule rule) {
        return allocationRuleService.saveRule(rule);
    }

    @GetMapping
    public List<AllocationRule> getAllRules() {
        return allocationRuleService.getAllRules();
    }

    @GetMapping("/{id}")
    public AllocationRule getRule(@PathVariable Long id) {
        return allocationRuleService.getRuleById(id);
    }
}
