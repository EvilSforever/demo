package com.example.demo.dao;

import com.example.demo.pojo.LoginLogCondition;
import com.example.demo.pojo.TLoginLog;

import java.util.List;

public interface TLoginLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login_log
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login_log
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    int insert(TLoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login_log
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    int insertSelective(TLoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login_log
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    TLoginLog selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login_log
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    int updateByPrimaryKeySelective(TLoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_login_log
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    int updateByPrimaryKey(TLoginLog record);

    List<TLoginLog> selectLoginLog(LoginLogCondition condition);

    Integer countLoginLog(LoginLogCondition condition);
}