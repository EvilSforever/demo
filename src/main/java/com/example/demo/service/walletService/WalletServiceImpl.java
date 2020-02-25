package com.example.demo.service.walletService;

import com.example.demo.dao.TUserWalletMapper;
import com.example.demo.pojo.TUserWallet;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class WalletServiceImpl implements WalletService {

    @Autowired
    private TUserWalletMapper tUserWalletMapper;

    @Override
    public TUserWallet getWalletInfo(String userid) {
        TUserWallet tUserWallet=null;
        try {
            tUserWallet =tUserWalletMapper.getWalletInfo(userid);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("实现层异常");
        }
        return tUserWallet;
    }



}
