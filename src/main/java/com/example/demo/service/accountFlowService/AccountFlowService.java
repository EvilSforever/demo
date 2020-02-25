package com.example.demo.service.accountFlowService;

import com.example.demo.pojo.TAccountFlow;
import com.example.demo.pojo.TWithdraw;

public interface AccountFlowService {

    TAccountFlow query(String userid);
}
