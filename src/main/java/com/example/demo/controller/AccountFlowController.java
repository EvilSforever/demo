package com.example.demo.controller;

import com.example.demo.constans.ResultCodeAndMsg;
import com.example.demo.constans.ReturnResult;
import com.example.demo.pojo.TAccountFlow;
import com.example.demo.service.accountFlowService.AccountFlowService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class AccountFlowController {

    @Autowired
    private AccountFlowService accountFlowService;

    @RequestMapping(value = "/user/accountflow/query")
    public ReturnResult query(String userId){
        ReturnResult returnResult=null;
        try {

            TAccountFlow tAccountFlow=accountFlowService.query(userId);
            if (tAccountFlow!=null){
                returnResult=new ReturnResult(ResultCodeAndMsg.success.getCode(),ResultCodeAndMsg.success.getMsg(),tAccountFlow);
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
