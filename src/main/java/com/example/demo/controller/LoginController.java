package com.example.demo.controller;

import com.example.demo.constans.ResultCodeAndMsg;
import com.example.demo.constans.ReturnResult;
import com.example.demo.pojo.LoginLogCondition;

import com.example.demo.service.loginService.LoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Log4j2
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/system/loginlog/query",method = RequestMethod.POST)
    public ReturnResult QueryLoginLog(LoginLogCondition loginLogCondition){
        ReturnResult returnResult=null;
        try {
            Map<String,Object> map=loginService.query(loginLogCondition);
            if (map!=null){
                returnResult=new ReturnResult(ResultCodeAndMsg.success.getCode(),ResultCodeAndMsg.success.getMsg(),map);
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
