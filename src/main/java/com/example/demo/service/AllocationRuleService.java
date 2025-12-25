package com.example.demo.service; 
import org.springframework.stereotype.Service; 
import com.example.demo.entity.AllocationRule; 
import java.util.List; 
@Service 
public interface AllocationRuleService { 
AllocationRule createRule(AllocationRule rule); 
AllocationRule getRule(Long id); 
List<AllocationRule> getAllRules(); 
}