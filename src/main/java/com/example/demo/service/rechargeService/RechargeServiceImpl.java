package com.example.demo.service.rechargeService;

import com.example.demo.dao.TBankCardMapper;
import com.example.demo.dao.TRechargeMapper;
import com.example.demo.pojo.RechergeCondition;
import com.example.demo.pojo.TBankCard;
import com.example.demo.pojo.TRecharge;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Log4j2
public class RechargeServiceImpl implements RechargeService {

    @Autowired
    private TRechargeMapper tRechargeMapper;


    @Override
    public int insertRechargeAdd(TRecharge tRecharge) {
        tRecharge.setId(UUID.randomUUID().toString().replace("-",""));
        tRecharge.setTradeNo(UUID.randomUUID().toString().replace("-",""));
        tRecharge.setRechargeTime(new Date());
        int count =tRechargeMapper.insertSelective(tRecharge);
        if (count>0){
            return count;
        }else{
            return 0;
        }
    }

    @Override
    public Integer rechargeCount(RechergeCondition rechergeCondition) {
        return tRechargeMapper.rechargeCount(rechergeCondition);
    }

    @Override
    public Map<String, Object> query(RechergeCondition rechergeCondition) {
        Map<String, Object> rechergMap= null;
        try {
            rechergMap = new HashMap<>(16);
            log.error(rechergeCondition.getBeginDate()+"\n"+rechergeCondition.getEndDate()+"\n"+rechergeCondition.getState()+"\n"+rechergeCondition.getUserId()+"\n"+rechergeCondition.getCurrentPage());
            Integer integer = tRechargeMapper.rechargeCount(rechergeCondition);
            rechergeCondition.setTotalCont(integer);
            List<TRecharge> list= tRechargeMapper.query(rechergeCondition);
            rechergMap.put("listData",list);
            rechergMap.put("totalPage",rechergeCondition.getTotalPage());
            rechergMap.put("currentPage",rechergeCondition.getCurrentPage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rechergMap;
    }

    @Override
    public int updataRecherge(TRecharge tRecharge) {
        return tRechargeMapper.updateByPrimaryKeySelective(tRecharge);
    }
}
