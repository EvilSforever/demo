package com.example.demo.service.bidService;

import com.example.demo.dao.TBidMapper;
import com.example.demo.dao.TBorrowMapper;
import com.example.demo.dao.TRepaymentMapper;
import com.example.demo.dao.TUserWalletMapper;
import com.example.demo.pojo.*;
import com.example.demo.util.MyUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Log4j2
public class BidServiceImpl implements  BidService {

    @Autowired
    private TBidMapper bidMapper;
    @Autowired
    private TBorrowMapper borrowMapper;
    @Autowired
    private TUserWalletMapper walletMapper;
    @Autowired
    private TRepaymentMapper repaymentMapper;


    @Override
    public List<TBid> getBidBorrwoId(String borrowId) {
        return bidMapper.getBidBorrwoId(borrowId);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public int updataBid(TBid tBid) {

        TBorrow borrow=null;
        int count=0;
        int Bidcount=0;
        int borCount=0;
        int wallCount=0;
        try {
            borrow=borrowMapper.select(tBid.getBorrowId());
            String id=borrow.getId();
            Integer BidNum=borrow.getBidNum();//投标数量
            Long Interest=borrow.getTotalInterest();//借款利息
            /**
             * 1、新增bid投标表
             */
            tBid.setId(MyUtil.UUID);//设置id
            tBid.setBorrowTitle(borrow.getTitle());//借款标题
            tBid.setBidInterest(borrow.getTotalInterest());//借款利息
            tBid.setYearRate(borrow.getYearRate());//年化率
            tBid.setBorrowState(borrow.getBorrowState());//借款状态
            tBid.setBidTime(new Date());//投标时间
            tBid.setCreateTime(new Date());//创建时间
            Bidcount=bidMapper.insertSelective(tBid);
            if (Bidcount>0){
                /**
                 * 2、修改借款表
                 */
                borrow.setBorrowId(id);
                borrow.setBorrowState(30);//投标状态
                borrow.setBidNum(BidNum+1);//投标数量
                borrow.setCurrentBidAmount(tBid.getBidAmount());//已投金额
                borrow.setCurrentBidInterest(Interest);//已投利息
                borCount=borrowMapper.updateByPrimaryKeySelective(borrow);
                if (borCount>0){
                    /**
                     * 投标人钱包扣钱
                     */
                    TUserWallet wallet =walletMapper.getWalletInfo(tBid.getBidUserId());
                    Long money=wallet.getAvailableAmount();//用户可用余额
                    //修改用户钱包可用余额
                    wallet.setAvailableAmount(money-tBid.getBidAmount());
                    //增加用户冻结金额
                    wallet.setFreezeAmount(tBid.getBidAmount());
                    wallCount=walletMapper.updateByPrimaryKeySelective(wallet);
                    if (wallCount>0&&borCount>0&&Bidcount>0){
                        count=1;
                    }else{
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    }
                }else{
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                }
            }else{
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("投标Service异常");
            throw new RuntimeException(e);
        }
        return count;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public int updataaudit(TBorrow tBorrow) {
        /*投标对象*/
        TBid bid=bidMapper.getBorrwoId(tBorrow.getBorrowId());
        /*投标人钱包*/
        TUserWallet wallet=walletMapper.getWalletInfo(bid.getBidUserId());
        /*借款人借款信息*/
        TBorrow borrow=borrowMapper.getBorrowId(tBorrow.getBorrowId());
        String id=borrow.getId();
        borrow.setBorrowId(id);

        /*借款人钱包*/
        TUserWallet botWall=walletMapper.getWalletInfo(borrow.getBorrowUserId());
        Long borMoney=botWall.getAvailableAmount();//借款人原可用金额

        Long djMoney=wallet.getFreezeAmount();//冻结金额
        Long money=wallet.getAvailableAmount();//可用余额

        Long bSumMoney=borrow.getBorrowAmount()/borrow.getRepaymentMonth();//本期还款总本金
        System.out.println("本期还款总本金："+bSumMoney);
        Long lSumMoney=borrow.getTotalInterest()/borrow.getRepaymentMonth();//本期还款总利息
        System.out.println("本期还款总利息："+lSumMoney);
        Long sumMoney=bSumMoney+lSumMoney;//本期还款总额
        System.out.println("本期还款总额："+sumMoney);
        Long borSumMoney=(borrow.getBorrowAmount()+borrow.getTotalInterest())+botWall.getRepaidAmount();//借款人待还总额
        System.out.println("借款人待还总额："+borSumMoney+"借款总额："+borrow.getBorrowAmount()+"借款总利："+borrow.getTotalInterest()+"借款人钱包待还金额："+botWall.getRepaidAmount());

        int count=0;
        int wallCount=0;
        int borCount=0;
        int borWallCount=0;
        int reCount=0;

        switch (tBorrow.getBorrowState()){
            /**
             * 审核拒绝：31
             */
            case 31:
                /**
                 * 撤回投资人冻结金额
                 * 返回投资人可用金额
                 * 修改借款人借款状态
                 */
                wallet.setFreezeAmount(new Long(0));//返回投标冻结金额
                wallet.setAvailableAmount(money+djMoney);//返回投标人可用金额
                wallCount=walletMapper.updateByPrimaryKeySelective(wallet);/*修改投标人钱包*/
                if (wallCount>0){
                    borrow.setBorrowState(BorrowStateConst.LOAN_AUDIT_REJECT);
                    borCount=borrowMapper.updateByPrimaryKeySelective(borrow);/*修改借款人借款状态*/
                    if (borCount>0&&wallCount>0){
                        count=1;
                        //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    }else{
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    }
                }else{
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                }
                break;
            /**
             * 审核通过：32
             */
            case 32:
                /**
                 * 修改投资人wall表
                 * 修改投标人待收利息
                 * 修改投标人待收本金
                 * 修改投标人冻结金额
                 *
                 * wall表
                 * 修改借款人可用金额
                 * 修改借款人待还本息
                 *
                 * borr表
                 * 修改借款人借款状态borr表
                 *
                 * t_repayment表
                 * 根据借款人借款期数生成相应还款记录
                 */
                wallet.setInterestPending(borrow.getTotalInterest());//待收利息
                wallet.setPrincipalPending(borrow.getBorrowAmount());//待收利息
                wallet.setFreezeAmount(new Long(0));//冻结金额
               wallCount=walletMapper.updateByPrimaryKeySelective(wallet);
                if (wallCount>0){//修改投标人信息成功，修改借款人wall信息
                    botWall.setAvailableAmount(borMoney+djMoney);//借款人可用金额
                    botWall.setRepaidAmount(borSumMoney);//借款人待还金额
                    borWallCount=walletMapper.updateByPrimaryKeySelective(botWall);

                    if (borWallCount>0){//修改借款人wall信息成功，修改借款人借款状态
                        borrow.setBorrowState(BorrowStateConst.REPAYMENT);
                        borCount=borrowMapper.updateByPrimaryKeySelective(borrow);

                        if (borCount>0){//借款人借款状态修改成功，生成还款记录

                            for (int i=1;i<=borrow.getRepaymentMonth();i++) {
                                TRepayment repayment = new TRepayment();
                                //id
                                repayment.setId(java.util.UUID.randomUUID().toString().replace("-",""));

                                //借款id
                                repayment.setBorrowId(borrow.getId());

                                //借款人id
                                repayment.setBorrowUserId(borrow.getBorrowUserId());

                                //借款标题
                                repayment.setBorrowTitle(borrow.getTitle());

                                // 截止日期
                                Date date = new Date();
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(date);//设置起时间
                                cal.add(Calendar.MONTH, i);
                                repayment.setDeadline(cal.getTime());

                                //本期还款总金额
                                repayment.setTotalAmount(sumMoney);

                                //本期还款本金
                                repayment.setPrincipal(bSumMoney);

                                //本期还款总利息
                                repayment.setInterest(lSumMoney);

                                //还款期数
                                repayment.setPeriod(i);

                                //还款状态
                                repayment.setState(2);

                                //借款类型
                                repayment.setBorrowType(borrow.getBorrowType());

                                //还款方式
                                repayment.setRepaymentType(borrow.getRepaymentType());

                                //创建时间
                                repayment.setCreateTime(new Date());

                                reCount=repaymentMapper.insertSelective(repayment);
                            }//for循环

                            if (reCount>0&&borWallCount>0&&borCount>0&&wallCount>0){
                                count=1;
                            }else{
                                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                            }//还款信息
                        }
                    }
                }
                break;
        }
        return count;
    }
}
