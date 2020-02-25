package com.example.demo.service.bidService;

import com.example.demo.pojo.TBid;
import com.example.demo.pojo.TBorrow;

import java.util.List;

public interface BidService {
    List<TBid> getBidBorrwoId(String borrowId);
    int updataBid(TBid tBid);
    int updataaudit(TBorrow tBorrow);
}
