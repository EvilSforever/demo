package com.example.demo.controller;

import com.example.demo.constans.ResultCodeAndMsg;
import com.example.demo.constans.ReturnResult;
import com.example.demo.pojo.RechergeCondition;
import com.example.demo.pojo.TRecharge;
import com.example.demo.service.rechargeService.RechargeService;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 我要充值Controller
 */
@RestController
@Log4j2
public class RechargeController {

    @Autowired
    private RechargeService rechargeService;

    @RequestMapping(value = "/system/recharge/add")
    public ReturnResult rechargeAdd(TRecharge tRecharge){
        ReturnResult returnResult;
        try {
            int count=rechargeService.insertRechargeAdd(tRecharge);
            if(count>0){
                returnResult=new ReturnResult(ResultCodeAndMsg.success.getCode(),ResultCodeAndMsg.success.getMsg(),tRecharge);
            }else{
                returnResult=new ReturnResult(ResultCodeAndMsg.dateNull.getCode(),ResultCodeAndMsg.dateNull.getMsg(),tRecharge);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
            returnResult=new ReturnResult(ResultCodeAndMsg.exception.getCode(),ResultCodeAndMsg.exception.getMsg(),tRecharge);
        }
        return returnResult;
    }

    @RequestMapping(value = "/system/recharge/query",method = RequestMethod.POST)
    public ReturnResult rechargeQuery(RechergeCondition rechergeCondition){
        ReturnResult returnResult;
        Map<String,Object> map=new HashMap<>(16);
        try {
            map= rechargeService.query(rechergeCondition);
            returnResult=new ReturnResult(ResultCodeAndMsg.success.getCode(),ResultCodeAndMsg.success.getMsg(),map);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
            returnResult=new ReturnResult(ResultCodeAndMsg.exception.getCode(),ResultCodeAndMsg.exception.getMsg());
        }
        return returnResult;
    }
    @RequestMapping(value = "/system/recharge/audit")
    public ReturnResult audit(TRecharge tRecharge){
        ReturnResult returnResult=null;
        int count=0;
        try {
           count= rechargeService.updataRecherge(tRecharge);
           if (count>0){
               returnResult=new ReturnResult(ResultCodeAndMsg.success.getCode(),ResultCodeAndMsg.success.getMsg());
           }else{
               returnResult=new ReturnResult(ResultCodeAndMsg.dateNull.getCode(),ResultCodeAndMsg.dateNull.getMsg());
           }

        } catch (Exception e) {
            e.printStackTrace();
            returnResult=new ReturnResult(ResultCodeAndMsg.exception.getCode(),ResultCodeAndMsg.exception.getMsg());
        }
        return  returnResult;
    }
}
