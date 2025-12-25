package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AllocationRule;

@Repository
public interface AllocationRuleRepository
        extends JpaRepository<AllocationRule, Long> {
}
