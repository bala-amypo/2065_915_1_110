package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class AllocationRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ruleName;

    private String ruleType = "FIRST_AVAILABLE";
    private Integer priorityWeight = 1;

    public AllocationRule() {}

    public AllocationRule(Long id, String ruleName, String ruleType, Integer priorityWeight) {
        this.id = id;
        this.ruleName = ruleName;
        this.ruleType = ruleType;
        this.priorityWeight = priorityWeight;
    }

    public AllocationRule(String ruleName, String ruleType, Integer priorityWeight) {
        this.ruleName = ruleName;
        this.ruleType = ruleType;
        this.priorityWeight = priorityWeight;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }
    public String getRuleType() { return ruleType; }
    public void setRuleType(String ruleType) { this.ruleType = ruleType; }
    public Integer getPriorityWeight() { return priorityWeight; }
    public void setPriorityWeight(Integer priorityWeight) { this.priorityWeight = priorityWeight; }
}
