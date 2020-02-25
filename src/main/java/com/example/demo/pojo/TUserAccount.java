package com.example.demo.pojo;

import java.util.Date;

public class TUserAccount {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_account.id
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_account.username
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_account.password
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_account.account_status
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private Integer accountStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_account.account_type
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private Integer accountType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_account.fill_userinfo
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private Integer fillUserinfo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_account.last_login_time
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private Date lastLoginTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_account.create_time
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_account.id
     *
     * @return the value of t_user_account.id
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */


    /**
     * 记录用户最后一次登录信息
     */
    private String lastLoginDate;

    public String getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_account.id
     *
     * @param id the value for t_user_account.id
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_account.username
     *
     * @return the value of t_user_account.username
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_account.username
     *
     * @param username the value for t_user_account.username
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_account.password
     *
     * @return the value of t_user_account.password
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_account.password
     *
     * @param password the value for t_user_account.password
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_account.account_status
     *
     * @return the value of t_user_account.account_status
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public Integer getAccountStatus() {
        return accountStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_account.account_status
     *
     * @param accountStatus the value for t_user_account.account_status
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_account.account_type
     *
     * @return the value of t_user_account.account_type
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public Integer getAccountType() {
        return accountType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_account.account_type
     *
     * @param accountType the value for t_user_account.account_type
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_account.fill_userinfo
     *
     * @return the value of t_user_account.fill_userinfo
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public Integer getFillUserinfo() {
        return fillUserinfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_account.fill_userinfo
     *
     * @param fillUserinfo the value for t_user_account.fill_userinfo
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setFillUserinfo(Integer fillUserinfo) {
        this.fillUserinfo = fillUserinfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_account.last_login_time
     *
     * @return the value of t_user_account.last_login_time
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_account.last_login_time
     *
     * @param lastLoginTime the value for t_user_account.last_login_time
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_account.create_time
     *
     * @return the value of t_user_account.create_time
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_account.create_time
     *
     * @param createTime the value for t_user_account.create_time
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


}