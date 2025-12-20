package com.example.demo.controller;

import com.example.demo.entity.AllocationRule;
import com.example.demo.service.AllocationRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/allocation-rules")
public class AllocationRuleController {

    private final AllocationRuleService allocationRuleService;

    public AllocationRuleController(AllocationRuleService allocationRuleService) {
        this.allocationRuleService = allocationRuleService;
    }

    @PostMapping
    public AllocationRule create(@RequestBody AllocationRule rule) {
        return allocationRuleService.createRule(rule);
    }

    @GetMapping("/{id}")
    public AllocationRule getById(@PathVariable Long id) {
        return allocationRuleService.getRule(id);
    }

    @GetMapping
    public List<AllocationRule> getAll() {
        return allocationRuleService.getAllRules();
    }
}
