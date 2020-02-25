package com.example.demo.service.repaymentService;

import com.example.demo.dao.TRepaymentDetailMapper;
import com.example.demo.pojo.TRepayment;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Log4j2
public class RepaymentServiceImpl implements RepaymentService {

    @Autowired
    private TRepaymentDetailMapper repaymentDetailMapper;

    @Override
    public List<TRepayment> getBorrowId(String borrowId) {
        List<TRepayment> list=null;
        try {
            list=repaymentDetailMapper.getBorrowId(borrowId);
            if (list!=null){
                return list;
            }else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("还款查询Service异常");
        }
        return list;
    }
}
