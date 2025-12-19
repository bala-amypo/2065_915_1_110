package com.example.demo.controller;

import com.example.demo.entity.AllocationRule;
import com.example.demo.dto.ApiResponse;
import com.example.demo.service.AllocationRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class AllocationRuleController {

    private final AllocationRuleService ruleService;

    @Autowired
    public AllocationRuleController(AllocationRuleService ruleService){
        this.ruleService = ruleService;
    }

    @PostMapping
    public ApiResponse createRule(@RequestBody AllocationRule rule){
        AllocationRule created = ruleService.createRule(rule);
        return new ApiResponse(true, "Rule created successfully", created);
    }

    @GetMapping
    public List<AllocationRule> getAllRules(){
        return ruleService.getAllRules();
    }

    @GetMapping("/{id}")
    public AllocationRule getRule(@PathVariable Long id){
        return ruleService.getRule(id);
    }
}
