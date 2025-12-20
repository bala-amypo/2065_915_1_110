package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "allocation_rules",
    uniqueConstraints = @UniqueConstraint(columnNames = "ruleName")
)
public class AllocationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;

    private String ruleType;

    private Integer priorityWeight;

    private LocalDateTime createdAt;

    public AllocationRule() {
    }

    public AllocationRule(Long id, String ruleName, String ruleType, Integer priorityWeight) {
        this.id = id;
        this.ruleName = ruleName;
        this.ruleType = ruleType;
        this.priorityWeight = priorityWeight;
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // getters and setters

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
}
