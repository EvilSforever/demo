package com.example.demo.service.repaService;

import com.example.demo.pojo.RepaCondition;
import com.example.demo.pojo.TRepayment;

import java.util.Map;

public interface RepaService {
    Integer count(RepaCondition repaCondition);
    Map<String,Object> query(RepaCondition repaCondition);
    int repay(String id,String userId);
}
