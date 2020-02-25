package com.example.demo.controller;

import com.example.demo.constans.ResultCodeAndMsg;
import com.example.demo.constans.ReturnResult;
import com.example.demo.pojo.BorrowCondition;
import com.example.demo.pojo.TBid;
import com.example.demo.pojo.TBorrow;
import com.example.demo.pojo.TRepayment;
import com.example.demo.service.bidService.BidService;
import com.example.demo.service.borrowService.BorrowService;
import com.example.demo.service.repaymentService.RepaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Log4j2
public class BorrowController {

    @Autowired
    private BorrowService borrowService;
    @Autowired
    private RepaymentService repaymentService;
    @Autowired
    private BidService bidService;


    @RequestMapping(value = "/finance/borrow/add")
    public ReturnResult borrowAdd(TBorrow tBorrow){
        ReturnResult returnResult=null;
        boolean isInsert=false;
        try {
            isInsert= borrowService.insertBorrow(tBorrow);
           if (isInsert){
               returnResult=new ReturnResult(ResultCodeAndMsg.success.getCode(),ResultCodeAndMsg.success.getMsg());
           }else{
               returnResult=new ReturnResult(ResultCodeAndMsg.dateNull.getCode(),ResultCodeAndMsg.dateNull.getMsg());
           }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
            returnResult=new ReturnResult(ResultCodeAndMsg.exception.getCode(),ResultCodeAndMsg.exception.getMsg());
        }
        return returnResult;
    }
    @RequestMapping(value = "/finance/borrow/query")
    public ReturnResult query(BorrowCondition borrowCondition){
        ReturnResult returnResult=null;
        Map<String ,Object> map=new HashMap<>();
        try {
            map=borrowService.query(borrowCondition);
            if(map!=null) {
                returnResult = new ReturnResult(ResultCodeAndMsg.success.getCode(), ResultCodeAndMsg.success.getMsg(), map);
            }else{
                returnResult=new ReturnResult(ResultCodeAndMsg.dateNull.getCode(),ResultCodeAndMsg.dateNull.getMsg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
            returnResult=new ReturnResult(ResultCodeAndMsg.exception.getCode(),ResultCodeAndMsg.exception.getMsg());
        }
        return returnResult;
    }

    @RequestMapping(value = "/finance/borrow/audit")
    public ReturnResult audit(TBorrow tBorrow){
        ReturnResult returnResult=null;
        try {
            boolean isYes = borrowService.updateBorrow(tBorrow);
            if (isYes){
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

    /*借款信息查询*/
    @RequestMapping(value = "/finance/borrow/get/{borrowId}")
    public ReturnResult getBorrowId(@PathVariable String borrowId){
        ReturnResult returnResult=null;
       // log.error("borrowId：{}",borrowId);
        try {
            TBorrow borrow=borrowService.borrowId(borrowId);
            if (borrow!=null){
                returnResult=new ReturnResult(ResultCodeAndMsg.success.getCode(),ResultCodeAndMsg.success.getMsg(),borrow);
            }else{
                returnResult=new ReturnResult(ResultCodeAndMsg.dateNull.getCode(),ResultCodeAndMsg.dateNull.getMsg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
            returnResult=new ReturnResult(ResultCodeAndMsg.exception.getCode(),ResultCodeAndMsg.exception.getMsg());
        }
        return returnResult;
    }

    /*还款信息查询*/
    @RequestMapping(value = "/finance/repayment/getByBorrowId")
    public ReturnResult getByBorrwId(String borrowId){
        ReturnResult returnResult=null;
        log.error("哈哈哈"+borrowId);
        List<TRepayment> list=null;
        try {
            list=repaymentService.getBorrowId(borrowId);
            if (list!=null||list.size()>0){
                returnResult=new ReturnResult(ResultCodeAndMsg.success.getCode(),ResultCodeAndMsg.success.getMsg(),list);
            }else{
                returnResult=new ReturnResult(ResultCodeAndMsg.dateNull.getCode(),ResultCodeAndMsg.dateNull.getMsg());
            }
        } catch (Exception e) {
                e.printStackTrace();
                returnResult=new ReturnResult(ResultCodeAndMsg.exception.getCode(),ResultCodeAndMsg.exception.getMsg());
                log.error(e.getMessage(),e);
        }
        return returnResult;
    }

    /*招标信息查询*/
    @RequestMapping(value = "/finance/bid/getByBorrowId/{borrowId}")
    public ReturnResult getByBorrowId(@PathVariable String borrowId){
        ReturnResult returnResult=null;
        List<TBid> list=null;
        try {
            list=bidService.getBidBorrwoId(borrowId);
            if (list!=null||list.size()>0){
                returnResult=new ReturnResult(ResultCodeAndMsg.success.getCode(),ResultCodeAndMsg.success.getMsg(),list);
            }else{
                returnResult=new ReturnResult(ResultCodeAndMsg.dateNull.getCode(),ResultCodeAndMsg.dateNull.getMsg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnResult=new ReturnResult(ResultCodeAndMsg.exception.getCode(),ResultCodeAndMsg.exception.getMsg());
            log.error(e.getMessage(),e);
        }
        return returnResult;
    }

}
