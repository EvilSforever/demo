package com.example.demo.service.repaService;

import com.example.demo.dao.*;
import com.example.demo.pojo.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.NoTransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;

@Service
@Log4j2
public class RepaServiceImpl implements  RepaService {

    @Autowired
    private TRepaymentMapper repaymentMapper;
    @Autowired
    private TBidMapper bidMapper;
    @Autowired
    private TUserWalletMapper walletMapper;
    @Autowired
    private TRepaymentDetailMapper detailMapper;
    @Autowired
    private TBorrowMapper borrowMapper;



    @Override
    public Integer count(RepaCondition repaCondition) {
        Integer count=null;
        try {
            count=repaymentMapper.count(repaCondition);
            if (count>0){
                System.out.println("大小："+count);
                return count;
            }else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public Map<String, Object> query(RepaCondition repaCondition) {
        Map<String, Object> map=new HashMap<>(16);
        repaCondition.setTotalCont(count(repaCondition));
        List<TRepayment> list=repaymentMapper.query(repaCondition);
        map.put("listData",list);
        map.put("totalPage",repaCondition.getTotalPage());
        map.put("currentPage",repaCondition.getCurrentPage());
        return map;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public int repay(String id, String userId) {
        int count=0;
        int borCount=0;
        int bidCount=0;
        int detailCount=0;
        int repaCount=0;
        int borrCount=0;

        try {
            /*根据id和借款人id查询  还款信息、并获取标的id*/
            TRepayment repayment=repaymentMapper.getRepayInfo(id,userId);
            //本期还款总金额
            Long thisRepaSumMoney=repayment.getTotalAmount();
            //本期还款本金
            Long thisRepaBenMoney=repayment.getPrincipal();
            //本期还款总利息
            Long thisRepaLiMoney=repayment.getInterest();
            //还款期数
            int thisMoth=repayment.getPeriod();
            //还款时间
            repayment.setRepaymentTime(new Date());
            repayment.setState(3);
            /*获取标的id查询投标人信息*/
            TBid bid=bidMapper.getBorrwoId(repayment.getBorrowId());
            log.error("投标人ID：{}",bid.getBidUserId());

            /*根据投标人id信息查询 投标人钱包*/
            TUserWallet bidWall=walletMapper.getWallInfo(bid.getBidUserId());

            /*根据借款人id查询 借款人钱包*/
            TUserWallet borWall=walletMapper.getWallInfo(userId);



            /*修改借款人的钱包信息*/
            //减少借款人的可用金额
            borWall.setAvailableAmount(borWall.getAvailableAmount()-thisRepaSumMoney);
            //减少借款人的待还金额
            borWall.setRepaidAmount(borWall.getRepaidAmount()-thisRepaSumMoney);
            borCount=walletMapper.updateByPrimaryKeySelective(borWall);
            if (borCount<1){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }

            /*修改投标人的钱包信息*/
            //增加投标人的可用金额
            bidWall.setAvailableAmount(bidWall.getAvailableAmount()+thisRepaSumMoney);
            //减少投标人的待收本金
            bidWall.setPrincipalPending(bidWall.getPrincipalPending()-thisRepaBenMoney);
            //减少投标人的待收利息
            bidWall.setInterestPending(bidWall.getInterestPending()-thisRepaLiMoney);
            bidCount=walletMapper.updateByPrimaryKeySelective(bidWall);
            if (bidCount<1){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }

            /*新增还款记录*/
            TRepaymentDetail detail=new TRepaymentDetail();
            //id
            detail.setId(UUID.randomUUID().toString().replace("-",""));
            //标的id
            detail.setBidId(bid.getBidUserId());
            //借款id
            detail.setBorrowId(repayment.getBorrowId());
            //还款id
            detail.setRepaymentId(repayment.getId());
            //借款人id
            detail.setBorrowUserId(userId);
            //投标人id
            detail.setBidUserId(bid.getBidUserId());
            //借款标题
            detail.setBorrowTitle(repayment.getBorrowTitle());
            //本期还款总金额
            detail.setTotalAmount(thisRepaSumMoney);
            //本期还款本金
            detail.setPrincipal(thisRepaBenMoney);
            //本期还款利息
            detail.setInterest(thisRepaLiMoney);
            //还款期数
            detail.setPeriod(thisMoth);
            //还款状态
            //本期还款截止日期
            detail.setDeadline(repayment.getDeadline());
            //还款时间
            detail.setRepaymentTime(new Date());
            //还款方式
            detail.setRepaymentType(repayment.getRepaymentType());
            detail.setCreateTime(new Date());
            detailCount=detailMapper.insertSelective(detail);
            if (detailCount<1){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
            repaCount= repaymentMapper.updateByPrimaryKeySelective(repayment);
            if (repaCount<1){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
            if (detailCount>0&&borCount>0&&bidCount>0&&repaCount>0){
                count=1;
            }else{
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
            /*如果按期还完修改还款状态*/
            TBorrow borrow=borrowMapper.getBorrowId(repayment.getBorrowId());
            borrow.setId(borrow.getBorrowId());
            if (borrow.getRepaymentMonth()==thisMoth){
                borrow.setBorrowState(BorrowStateConst.REPAYMENT_CLEARED);
                borrCount=borrowMapper.updateByPrimaryKeySelective(borrow);
                if (borrCount<1){
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                }
            }
        } catch (NoTransactionException e) {
            e.printStackTrace();
            System.err.println("还款Service异常");
        }
        return count;
    }
}
