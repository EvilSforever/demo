package com.example.demo.controller;

import com.example.demo.constans.ResultCodeAndMsg;
import com.example.demo.constans.ReturnResult;
import com.example.demo.pojo.RegisterUser;
import com.example.demo.pojo.TLoginLog;
import com.example.demo.pojo.TUserAccount;
import com.example.demo.service.userService.UserAccountService;
import com.example.demo.util.MD5;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RestController
@Log4j2
public class UserController {

    @Autowired
    private UserAccountService userAccountService;


    /**
     * 验证用户名是否存在
     * @param name
     * @return
     */
    @RequestMapping(value = "/user/checkUsername",
                    method = RequestMethod.POST)
    public boolean chekUserName(@RequestParam("username") String name){
          boolean br=userAccountService.checkUserName(name);
          return br;
    }



    @RequestMapping(value = "/user/register",
            method = RequestMethod.POST)
    public ReturnResult userRegister(String username, String password) {
       ReturnResult returnResult;
        try {
            RegisterUser registerUser = new RegisterUser();
            registerUser.setUserNmae(username);
            registerUser.setPassword(password);
            boolean result = userAccountService.insertAccountUser(registerUser);
            if (result) {
                returnResult=new ReturnResult(ResultCodeAndMsg.success.getCode(),ResultCodeAndMsg.success.getMsg());
            } else {
                returnResult=new ReturnResult(ResultCodeAndMsg.fail.getCode(),ResultCodeAndMsg.fail.getMsg());
            }
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            returnResult=new ReturnResult();
        }
        return returnResult;
    }

    @RequestMapping(value = "/user/login")
    public ReturnResult login(String username, String password, Integer accountType,HttpServletRequest request){
        ReturnResult returnResult=null;
        try {
            if (StringUtils.isEmpty(username)){
                returnResult=new ReturnResult(ResultCodeAndMsg.userNameIsNull.getCode(),ResultCodeAndMsg.userNameIsNull.getMsg());
                return returnResult;
            }else if(StringUtils.isEmpty(password)){
                returnResult=new ReturnResult(ResultCodeAndMsg.userPasswordIsNull.getCode(),ResultCodeAndMsg.userPasswordIsNull.getMsg());
                return returnResult;
            }
            String md5Pwd= MD5.encode(password);
            String ip=request.getRemoteAddr();
            TUserAccount tUserAccount=userAccountService.userLogin(username,md5Pwd,accountType,ip);
            if (tUserAccount==null){
                returnResult=new ReturnResult(ResultCodeAndMsg.userNameOrPwdError.getCode(),ResultCodeAndMsg.userNameOrPwdError.getMsg());
            }else{
                returnResult=new ReturnResult(ResultCodeAndMsg.success.getCode(),ResultCodeAndMsg.success.getMsg(),tUserAccount);
                request.getSession().setAttribute("userAccount",tUserAccount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnResult;
    }
}
