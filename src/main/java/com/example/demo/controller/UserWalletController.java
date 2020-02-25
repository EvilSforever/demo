package com.example.demo.controller;

import com.example.demo.constans.ResultCodeAndMsg;
import com.example.demo.constans.ReturnResult;
import com.example.demo.pojo.TUserWallet;
import com.example.demo.service.walletService.WalletService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class UserWalletController {

    @Autowired
    private WalletService walletService;
    @RequestMapping(value = "/user/wallet/get/{userid}")
    public ReturnResult getWallet(@PathVariable String userid){
        ReturnResult returnResult=null;
        try {
           TUserWallet tUserWallet= walletService.getWalletInfo(userid);
           log.error(tUserWallet.getAvailableAmount());
           if(tUserWallet!=null) {
               returnResult = new ReturnResult(ResultCodeAndMsg.success.getCode(), ResultCodeAndMsg.success.getMsg(), tUserWallet);
           }else {
               returnResult = new ReturnResult(ResultCodeAndMsg.dateNull.getCode(), ResultCodeAndMsg.dateNull.getMsg());
           }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
            returnResult = new ReturnResult(ResultCodeAndMsg.exception.getCode(), ResultCodeAndMsg.exception.getMsg());
        }
        return returnResult;
    }


}
