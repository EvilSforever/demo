package com.example.demo.service.loginService;

import com.example.demo.pojo.LoginLogCondition;
import com.example.demo.pojo.TLoginLog;

import java.util.Map;

public interface LoginService {
   Integer LoginCount(LoginLogCondition loginLogCondition);

   Map<String,Object> query(LoginLogCondition loginLogCondition);
}
