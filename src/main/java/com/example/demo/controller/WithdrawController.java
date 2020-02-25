package com.example.demo.controller;

import com.example.demo.constans.ResultCodeAndMsg;
import com.example.demo.constans.ReturnResult;

import com.example.demo.pojo.TWithdraw;
import com.example.demo.service.withdrawService.WithdrawService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Log4j2
public class WithdrawController {

    @Autowired
    private WithdrawService withdrawService;

    @RequestMapping(value = "/user/withdraw/add")
    public ReturnResult withdrawAdd(TWithdraw tWithdraw){
        ReturnResult returnResult=null;
        try {
           int count = withdrawService.insertSelective(tWithdraw);
           if (count>0){
               returnResult=new ReturnResult(ResultCodeAndMsg.success.getCode(),ResultCodeAndMsg.success.getMsg());
           }else{
               returnResult=new ReturnResult(ResultCodeAndMsg.dateNull.getCode(),ResultCodeAndMsg.dateNull.getMsg());
           }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
            returnResult=new ReturnResult(ResultCodeAndMsg.exception.getCode(),ResultCodeAndMsg.exception.getMsg());
        }
        return null;
    }
}
