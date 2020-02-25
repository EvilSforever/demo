package com.example.demo.service.borrowService;

import com.example.demo.dao.TUserWalletMapper;
import com.example.demo.pojo.*;
import com.example.demo.util.MyUtil;
import com.example.demo.dao.TBorrowMapper;
import com.sun.xml.internal.bind.v2.TODO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.math.BigDecimal;
import java.util.*;

@Service
@Log4j2
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private TBorrowMapper tBorrowMapper;
    @Autowired
    private TUserWalletMapper tUserWalletMapper;

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean insertBorrow(TBorrow borrow) {
        try {
            borrow.setId(MyUtil.UUID);
            borrow.setBorrowType(BorrowTypeConstants.BORROW_TYPE_CREDITLOAN);
            borrow.setBorrowState(BorrowStateConst.PUBLISH_PENDING);
            borrow.setApplyTime(new Date());
            borrow.setCreateTime(new Date());
            BigDecimal bigDecimalYearRate = BigDecimal.valueOf((borrow.getYearRate() * 0.01) /12); //月利率
            double yearRate = bigDecimalYearRate.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
            if(borrow.getRepaymentType() == BorrowTypeConstants.REPAYMENT_TYPE_EVENS){
                //等额本息

                //[贷款本金 * 月利率 * (1+月利率)^还款月数] / [(1+月利率)^还款月数 - 1]

                //月利息
                BigDecimal bigDecimal = BigDecimal.valueOf((borrow.getBorrowAmount() * yearRate * Math.pow(1+yearRate,borrow.getRepaymentMonth())) /
                        (Math.pow(1+yearRate,borrow.getRepaymentMonth())-1));

                double monthMoney = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

                //总回报金额
                borrow.setTotalInterest((long) (monthMoney * borrow.getRepaymentMonth() - borrow.getBorrowAmount()));
            }else if (borrow.getRepaymentType() == BorrowTypeConstants.REPAYMENT_TYPE_FIRSTRATE){
                //先息后本
                //总利息 = （年化利息 ÷ 12） × 借款月数
                borrow.setTotalInterest((long) (yearRate  * borrow.getBorrowAmount() * borrow.getRepaymentMonth()));
            }
            tBorrowMapper.insertSelective(borrow);
            //修改用户剩余授信额度
            TUserWallet userWallet = tUserWalletMapper.selectByPrimaryKey(borrow.getBorrowUserId());
            userWallet.setResidualCreditLine(userWallet.getResidualCreditLine() - borrow.getBorrowAmount());
            tUserWalletMapper.updateByPrimaryKeySelective(userWallet);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public Integer count(BorrowCondition borrowCondition) {
        return tUserWalletMapper.count(borrowCondition);
    }

    @Override
    public Map<String, Object> query(BorrowCondition borrowCondition) {
        Map<String, Object> map=new HashMap<>();
        System.out.println("时间："+borrowCondition.getBeginDate());
        borrowCondition.setTotalCont(tUserWalletMapper.count(borrowCondition));
        System.out.println("大小："+borrowCondition.getTotalCont());
        try {
            List<TBorrow> list=tUserWalletMapper.query(borrowCondition);

            map.put("listData",list);
            map.put("totalPage",borrowCondition.getTotalPage());
            map.put("currentPage",borrowCondition.getCurrentPage());
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("借款查询Service异常" );
        }
        return map;
    }

    @Override
    public boolean updateBorrow(TBorrow borrow) {
        try {
            TBorrow tBorrow = tBorrowMapper.selectByPrimaryKey(borrow.getBorrowId());

            //审核通过
            if (borrow.getBorrowState() == BorrowStateConst.PUBLISH_AUDIT_PASS) {
                Date date = new Date(); //当前时间
                Calendar rightNow = Calendar.getInstance();//日历对象
                //招标截止日期
                rightNow.add(Calendar.DAY_OF_MONTH, tBorrow.getBidDays()); //当前时间+招标时间
                tBorrow.setBidDeadline(rightNow.getTime());

                //发标时间  
                tBorrow.setPublishTime(date);//设置当前日期

                //更新借款状态,改为招标中
                tBorrow.setBorrowState(20);
                tBorrowMapper.updateByPrimaryKeySelective(borrow);

            } else if (borrow.getBorrowState() == BorrowStateConst.PUBLISH_AUDIT_REJECT) { //发布审核拒绝
                TUserWallet userWallet1 = tUserWalletMapper.selectByPrimaryKey(tBorrow.getBorrowUserId());
                userWallet1.setResidualCreditLine(userWallet1.getResidualCreditLine() + tBorrow.getBorrowAmount());
                int count = tUserWalletMapper.updateByPrimaryKeySelective(userWallet1);
                if (count < 0) {
                    return false;
                }
                tBorrow.setBorrowState(BorrowStateConst.PUBLISH_AUDIT_REJECT);
                tBorrowMapper.updateByPrimaryKeySelective(borrow);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public TBorrow borrowId(String borrowId) {
        return tBorrowMapper.selectByPrimaryKey(borrowId);
    }

}
