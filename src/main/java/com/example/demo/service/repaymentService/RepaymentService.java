package com.example.demo.service.repaymentService;

import com.example.demo.pojo.TRepayment;

import java.util.List;

public interface RepaymentService {
    List<TRepayment> getBorrowId(String borrowId);
}
