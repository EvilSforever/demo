package com.example.demo.service.accountFlowService;

import com.example.demo.dao.TAccountFlowMapper;
import com.example.demo.dao.TWithdrawMapper;
import com.example.demo.pojo.TAccountFlow;
import com.example.demo.pojo.TWithdraw;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class AccountFlowServiceImpl implements AccountFlowService {

    @Autowired
    private TAccountFlowMapper tAccountFlowMapper;
    @Override
    public TAccountFlow query(String userid) {
        TAccountFlow tAccountFlow= null;
        try {
            tAccountFlow = tAccountFlowMapper.query(userid);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Withdraw实现类异常");
        }
        return tAccountFlow;
    }
}
