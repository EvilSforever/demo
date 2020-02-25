package com.example.demo.service.walletService;

import com.example.demo.pojo.TUserWallet;

public interface WalletService {

    /**
     * 根据用户id查询
     * @param userid
     * @return
     */
    TUserWallet getWalletInfo(String userid);

}
