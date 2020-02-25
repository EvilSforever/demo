package com.example.demo.controller;

import com.example.demo.constans.ResultCodeAndMsg;
import com.example.demo.constans.ReturnResult;
import com.example.demo.pojo.TBid;
import com.example.demo.pojo.TBorrow;
import com.example.demo.service.bidService.BidService;
import com.example.demo.service.borrowService.BorrowService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class BidController {

    @Autowired
    private BidService bidService;
    @Autowired
    private BorrowService borrowService;

    @RequestMapping(value = "/finance/bid/add")
    public ReturnResult addBid(TBid tBid){
        ReturnResult returnResult=null;
        int count=0;
        try {
            count=bidService.updataBid(tBid);
            if (count>0){
                returnResult=new ReturnResult(ResultCodeAndMsg.success.getCode(),ResultCodeAndMsg.success.getMsg());
            }else{
                returnResult=new ReturnResult(ResultCodeAndMsg.dateNull.getCode(),ResultCodeAndMsg.dateNull.getMsg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnResult=new ReturnResult(ResultCodeAndMsg.exception.getCode(),ResultCodeAndMsg.exception.getMsg());
        }
        return returnResult;
    }

    @RequestMapping(value = "/finance/loan/audit")
    public ReturnResult audit(TBorrow borrow){
        ReturnResult returnResult=null;
        int count=0;
        try {
            count=bidService.updataaudit(borrow);
            if (count>0){
                returnResult=new ReturnResult(ResultCodeAndMsg.success.getCode(),ResultCodeAndMsg.success.getMsg());
            }else{
                returnResult=new ReturnResult(ResultCodeAndMsg.dateNull.getCode(),ResultCodeAndMsg.dateNull.getMsg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnResult=new ReturnResult(ResultCodeAndMsg.exception.getCode(),ResultCodeAndMsg.exception.getMsg());
        }
        return  returnResult;
    }
}
