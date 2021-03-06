package com.example.demo.pojo;

import java.util.Date;

public class TWithdraw {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_withdraw.id
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_withdraw.user_id
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_withdraw.amount
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private Long amount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_withdraw.fee
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private Long fee;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_withdraw.bank_name
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private String bankName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_withdraw.realname
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private String realname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_withdraw.card_number
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private String cardNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_withdraw.branch_name
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private String branchName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_withdraw.create_time
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_withdraw.id
     *
     * @return the value of t_withdraw.id
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_withdraw.id
     *
     * @param id the value for t_withdraw.id
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_withdraw.user_id
     *
     * @return the value of t_withdraw.user_id
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_withdraw.user_id
     *
     * @param userId the value for t_withdraw.user_id
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_withdraw.amount
     *
     * @return the value of t_withdraw.amount
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_withdraw.amount
     *
     * @param amount the value for t_withdraw.amount
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_withdraw.fee
     *
     * @return the value of t_withdraw.fee
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public Long getFee() {
        return fee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_withdraw.fee
     *
     * @param fee the value for t_withdraw.fee
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setFee(Long fee) {
        this.fee = fee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_withdraw.bank_name
     *
     * @return the value of t_withdraw.bank_name
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_withdraw.bank_name
     *
     * @param bankName the value for t_withdraw.bank_name
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_withdraw.realname
     *
     * @return the value of t_withdraw.realname
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public String getRealname() {
        return realname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_withdraw.realname
     *
     * @param realname the value for t_withdraw.realname
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_withdraw.card_number
     *
     * @return the value of t_withdraw.card_number
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_withdraw.card_number
     *
     * @param cardNumber the value for t_withdraw.card_number
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber == null ? null : cardNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_withdraw.branch_name
     *
     * @return the value of t_withdraw.branch_name
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_withdraw.branch_name
     *
     * @param branchName the value for t_withdraw.branch_name
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setBranchName(String branchName) {
        this.branchName = branchName == null ? null : branchName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_withdraw.create_time
     *
     * @return the value of t_withdraw.create_time
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_withdraw.create_time
     *
     * @param createTime the value for t_withdraw.create_time
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}