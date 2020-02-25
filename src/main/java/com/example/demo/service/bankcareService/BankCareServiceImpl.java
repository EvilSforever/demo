package com.example.demo.service.bankcareService;

import com.example.demo.constans.SystemLimitConst;
import com.example.demo.dao.TBankCardMapper;
import com.example.demo.pojo.TBankCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BankCareServiceImpl implements BankCareService {

    @Autowired
    private TBankCardMapper tBankCardMapper;

    @Override
    public TBankCard getBackCarUserId(String userId) {
        return tBankCardMapper.getBackCarUserId(userId);
    }

    @Override
    public int insertSelective(TBankCard tBankCard) throws Exception {
        //绑定银行卡
        if (getBackCarUserId(tBankCard.getUserId())==null){
        tBankCard.setBalance(SystemLimitConst.MONEY_UNIT * 10000);
    }
        tBankCard.setId(UUID.randomUUID().toString().replace("-",""));
        return tBankCardMapper.insertSelective(tBankCard);
}
}
