package com.example.demo.controller;

import com.example.demo.constans.ResultCodeAndMsg;
import com.example.demo.constans.ReturnResult;
import com.example.demo.pojo.TBankCard;
import com.example.demo.service.bankcareService.BankCareService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class BanKcardController {

    @Autowired
    private BankCareService bankCareService;


    @RequestMapping(value = "/user/bankcard/get/{userid}",method = RequestMethod.POST)
    public ReturnResult getBankcardInfo(@PathVariable String userid){
        //加载用户钱包
        ReturnResult returnResult=null;
        try {
           TBankCard tBankCard = bankCareService.getBackCarUserId(userid);
           if (tBankCard==null){
               returnResult=new ReturnResult(404,"404");
           }else{
               returnResult=new ReturnResult(ResultCodeAndMsg.success.getCode(),ResultCodeAndMsg.success.getMsg(),tBankCard);
           }
        } catch (Exception e) {
            e.printStackTrace();
            returnResult=new ReturnResult(ResultCodeAndMsg.exception.getCode(),ResultCodeAndMsg.exception.getMsg());
        }
        return returnResult;
    }

    @RequestMapping(value = "/user/bankcard/add")
    public ReturnResult bankcardAdd(TBankCard tBankCard){
        ReturnResult returnResult=null;
        try {
             int count=bankCareService.insertSelective(tBankCard);
            if (count>0){
                returnResult=new ReturnResult(ResultCodeAndMsg.success.getCode(),ResultCodeAndMsg.success.getMsg(),tBankCard);
            }else{
               returnResult=new ReturnResult(ResultCodeAndMsg.dateNull.getCode(),ResultCodeAndMsg.dateNull.getMsg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
            returnResult=new ReturnResult(ResultCodeAndMsg.exception.getCode(),ResultCodeAndMsg.exception.getMsg());
        }
        return returnResult;
    }
}
