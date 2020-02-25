package com.example.demo.dao;

import com.example.demo.pojo.TBid;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TBidMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_bid
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_bid
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    int insert(TBid record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_bid
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    int insertSelective(TBid record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_bid
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    TBid selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_bid
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    int updateByPrimaryKeySelective(TBid record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_bid
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    int updateByPrimaryKey(TBid record);

    List<TBid> getBidBorrwoId(@Param("borrowId") String borrowId);

    TBid getBorrwoId(@Param("borrowId") String borrowId);

}