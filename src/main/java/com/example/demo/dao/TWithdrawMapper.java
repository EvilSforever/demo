package com.example.demo.dao;

import com.example.demo.pojo.TWithdraw;
import org.apache.ibatis.annotations.Param;

public interface TWithdrawMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_withdraw
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_withdraw
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    int insert(TWithdraw record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_withdraw
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    int insertSelective(TWithdraw record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_withdraw
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    TWithdraw selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_withdraw
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    int updateByPrimaryKeySelective(TWithdraw record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_withdraw
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    int updateByPrimaryKey(TWithdraw record);


}