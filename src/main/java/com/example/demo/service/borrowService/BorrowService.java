package com.example.demo.service.borrowService;

import com.example.demo.pojo.BorrowCondition;
import com.example.demo.pojo.TBorrow;

import java.util.Map;

public interface BorrowService {

    boolean insertBorrow(TBorrow tBorrow);

    Integer count(BorrowCondition borrowCondition);

    Map<String,Object> query(BorrowCondition borrowCondition);

    boolean updateBorrow(TBorrow tBorrow);

    TBorrow borrowId(String borrowId);



}
