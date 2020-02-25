package com.example.demo.service.rechargeService;

import com.example.demo.pojo.RechergeCondition;
import com.example.demo.pojo.TRecharge;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RechargeService {

    /**
     * 用户充值
     * @param tRecharge
     * @return
     */
    int insertRechargeAdd(TRecharge tRecharge);

    /**
     * 查询个数
     * @param rechergeCondition
     * @return
     */
    Integer rechargeCount(RechergeCondition rechergeCondition);

    /**
     * 根据条件查询
     * @param userid
     * @return
     */
    Map<String,Object> query(RechergeCondition rechergeCondition);

    int updataRecherge(TRecharge tRecharge);
}
