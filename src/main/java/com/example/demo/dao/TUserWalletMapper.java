package com.example.demo.dao;

import com.example.demo.pojo.BorrowCondition;
import com.example.demo.pojo.TBorrow;
import com.example.demo.pojo.TUserWallet;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUserWalletMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_wallet
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    int deleteByPrimaryKey(String accountId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_wallet
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    int insert(TUserWallet record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_wallet
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    int insertSelective(TUserWallet record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_wallet
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    TUserWallet selectByPrimaryKey(String accountId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_wallet
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    int updateByPrimaryKeySelective(TUserWallet record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_wallet
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    int updateByPrimaryKey(TUserWallet record);

    TUserWallet getWalletInfo(@Param("userId") String userid);

    List<TBorrow> query(@Param("borrowCondition") BorrowCondition borrowCondition);

    int count(@Param("borrowCondition")BorrowCondition borrowCondition);

    TUserWallet getWallInfo(@Param("accountId") String bidUserId);
}