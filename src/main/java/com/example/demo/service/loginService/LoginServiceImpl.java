package com.example.demo.service.loginService;

import com.example.demo.dao.TLoginLogMapper;
import com.example.demo.pojo.LoginLogCondition;
import com.example.demo.pojo.TLoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private TLoginLogMapper loginLogMapper;

    @Override
    public Integer LoginCount(LoginLogCondition loginLogCondition) {
       Integer count=loginLogMapper.countLoginLog(loginLogCondition);
        return count;
    }

    @Override
    public Map<String, Object> query(LoginLogCondition loginLogCondition) {
        Map<String,Object> map=new HashMap<>();
        List<TLoginLog> list=loginLogMapper.selectLoginLog(loginLogCondition);
        loginLogCondition.setTotalCont(LoginCount(loginLogCondition));
        map.put("listData",list);
        map.put("totalPage",loginLogCondition.getTotalPage());
        map.put("currentPage",loginLogCondition.getCurrentPage());
        return map;
    }
}
