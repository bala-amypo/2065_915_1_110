package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AllocationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;

    private String ruleType; // FIRST_AVAILABLE / PRIORITY_BASED / ROUND_ROBIN

    private Integer priorityWeight;

    private LocalDateTime createdAt;

    public AllocationRule() {
    }

    public AllocationRule(Long id, String ruleName, String ruleType,
                          Integer priorityWeight, LocalDateTime createdAt) {
        this.id = id;
        this.ruleName = ruleName;
        this.ruleType = ruleType;
        this.priorityWeight = priorityWeight;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public Integer getPriorityWeight() {
        return priorityWeight;
    }

    public void setPriorityWeight(Integer priorityWeight) {
        this.priorityWeight = priorityWeight;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
