package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "allocation_rules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AllocationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private String ruleType; // e.g., FIRST_AVAILABLE
    private Integer priorityWeight = 1;
}
