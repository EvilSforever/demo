package com.example.demo.service.withdrawService;

import com.example.demo.dao.TAccountFlowMapper;
import com.example.demo.dao.TBankCardMapper;
import com.example.demo.dao.TUserWalletMapper;
import com.example.demo.dao.TWithdrawMapper;
import com.example.demo.pojo.TAccountFlow;
import com.example.demo.pojo.TBankCard;
import com.example.demo.pojo.TUserWallet;
import com.example.demo.pojo.TWithdraw;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.UUID;

@Service
public class WithdrawServiceImpl implements WithdrawService {

    @Autowired
    private TWithdrawMapper tWithdrawMapper;
    @Autowired
    private TBankCardMapper tBankCardMapper;
    @Autowired
    private TAccountFlowMapper tAccountFlowMapper;
    @Autowired
    private TUserWalletMapper tUserWalletMapper;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public int insertSelective(TWithdraw tWithdraw) {
        // TODO 余额提现需要修改
        /*????*/
        TBankCard tBankCard = null;
        Long balance;   //????
        int withCount = 0;//????
        int bankCount = 0;//?????
        int flowCount = 0;//??????
        int sumCount = 0;//??????
        tWithdraw.setId(UUID.randomUUID().toString().replace("-",""));
        try {
            /*????*/
            withCount = tWithdrawMapper.insertSelective(tWithdraw);
            if (withCount > 0) {
                /*????????,???????*/
                tBankCard = tBankCardMapper.getBackCarUserId(tWithdraw.getUserId());
                balance = tBankCard.getBalance();
                //??id
                tBankCard.setUserId(tWithdraw.getUserId());

                //????
                tBankCard.setRealname(tWithdraw.getRealname());

                //????
                tBankCard.setBankName(tWithdraw.getBankName());

                //?????
                tBankCard.setCardNumber(tWithdraw.getCardNumber());

                //????
                tBankCard.setBranchName(tWithdraw.getBranchName());

                //????+???
                Long amountAndFee = tWithdraw.getAmount() + tWithdraw.getFee();
                //?????-(????+???)
                Long money = tBankCard.getBalance() - amountAndFee;
                //????
                tBankCard.setBalance(money);

                //????
                tBankCard.setCreateTime(new Date());

                /*?????*/
                bankCount = tBankCardMapper.updateWithdrawMoney(tBankCard);

                if (bankCount > 0) {
                    /*?????????,???????*/
                    TAccountFlow tAccountFlow = new TAccountFlow();
                    //??id
                    tAccountFlow.setAccountId(tWithdraw.getUserId());
                    //??
                    tAccountFlow.setAmount(balance);
                    //??????
                    tAccountFlow.setFlowType(1);
                    //????
                    tAccountFlow.setAvailableAmount(tBankCard.getBalance());
                    //????
                    tAccountFlow.setFreezeAmount(new Long(0));
                    //????
                    tAccountFlow.setRemark("??");
                    //????
                    tAccountFlow.setCreateTime(new Date());

                    /*???????*/
                    flowCount = tAccountFlowMapper.insertSelective(tAccountFlow);
                }else{
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                }
            }else{
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
            if (withCount>0&&bankCount>0&&flowCount>0){
                sumCount=1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return 0;
        }
}
