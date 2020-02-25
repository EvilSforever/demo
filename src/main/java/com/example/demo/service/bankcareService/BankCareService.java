package com.example.demo.service.bankcareService;

import com.example.demo.pojo.TBankCard;

public interface BankCareService {

    /**
     * 绑定银行卡
     * @param tBankCard
     * @return
     * @throws Exception
     */
    int insertSelective(TBankCard tBankCard)throws Exception;

    /**
     * 根据用户id查询
     * @param userId
     * @return
     */
    TBankCard getBackCarUserId(String userId);

}
