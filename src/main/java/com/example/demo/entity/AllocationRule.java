package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

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

    private String ruleType; // e.g., FIRST_AVAILABLE, ROUND_ROBIN

    private Integer priorityWeight = 1;
}
