package com.example.demo.controller;

import com.example.demo.entity.AllocationRule;
import com.example.demo.service.AllocationRuleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rules")
public class AllocationRuleController {

    private final AllocationRuleService ruleService;

    public AllocationRuleController(AllocationRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping("/create")
    public AllocationRule createRule(@RequestBody AllocationRule rule) {
        return ruleService.createRule(rule);
    }

    @GetMapping("/{id}")
    public AllocationRule getRule(@PathVariable Long id) {
        return ruleService.getRule(id);
    }

    @GetMapping("/all")
    public List<AllocationRule> getAllRules() {
        return ruleService.getAllRules();
    }
}
