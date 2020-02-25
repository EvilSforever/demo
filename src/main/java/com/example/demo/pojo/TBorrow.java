package com.example.demo.pojo;

import java.util.Date;

public class TBorrow {
    private String borrowId;

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_borrow.id
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_borrow.borrow_user_id
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private String borrowUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_borrow.borrow_username
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private String borrowUsername;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_borrow.title
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_borrow.description
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_borrow.repayment_type
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private Integer repaymentType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_borrow.borrow_type
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private Integer borrowType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_borrow.borrow_state
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private Integer borrowState;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_borrow.borrow_amount
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private Long borrowAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_borrow.year_rate
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private Integer yearRate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_borrow.repayment_month
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private Integer repaymentMonth;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_borrow.bid_num
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private Integer bidNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_borrow.total_interest
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private Long totalInterest;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_borrow.current_bid_amount
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private Long currentBidAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_borrow.current_bid_interest
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private Long currentBidInterest;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_borrow.bid_deadline
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private Date bidDeadline;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_borrow.bid_days
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private Integer bidDays;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_borrow.apply_time
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private Date applyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_borrow.publish_time
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private Date publishTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_borrow.create_time
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_borrow.id
     *
     * @return the value of t_borrow.id
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_borrow.id
     *
     * @param id the value for t_borrow.id
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_borrow.borrow_user_id
     *
     * @return the value of t_borrow.borrow_user_id
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public String getBorrowUserId() {
        return borrowUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_borrow.borrow_user_id
     *
     * @param borrowUserId the value for t_borrow.borrow_user_id
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setBorrowUserId(String borrowUserId) {
        this.borrowUserId = borrowUserId == null ? null : borrowUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_borrow.borrow_username
     *
     * @return the value of t_borrow.borrow_username
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public String getBorrowUsername() {
        return borrowUsername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_borrow.borrow_username
     *
     * @param borrowUsername the value for t_borrow.borrow_username
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setBorrowUsername(String borrowUsername) {
        this.borrowUsername = borrowUsername == null ? null : borrowUsername.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_borrow.title
     *
     * @return the value of t_borrow.title
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_borrow.title
     *
     * @param title the value for t_borrow.title
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_borrow.description
     *
     * @return the value of t_borrow.description
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_borrow.description
     *
     * @param description the value for t_borrow.description
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_borrow.repayment_type
     *
     * @return the value of t_borrow.repayment_type
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public Integer getRepaymentType() {
        return repaymentType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_borrow.repayment_type
     *
     * @param repaymentType the value for t_borrow.repayment_type
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setRepaymentType(Integer repaymentType) {
        this.repaymentType = repaymentType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_borrow.borrow_type
     *
     * @return the value of t_borrow.borrow_type
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public Integer getBorrowType() {
        return borrowType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_borrow.borrow_type
     *
     * @param borrowType the value for t_borrow.borrow_type
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setBorrowType(Integer borrowType) {
        this.borrowType = borrowType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_borrow.borrow_state
     *
     * @return the value of t_borrow.borrow_state
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public Integer getBorrowState() {
        return borrowState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_borrow.borrow_state
     *
     * @param borrowState the value for t_borrow.borrow_state
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setBorrowState(Integer borrowState) {
        this.borrowState = borrowState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_borrow.borrow_amount
     *
     * @return the value of t_borrow.borrow_amount
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public Long getBorrowAmount() {
        return borrowAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_borrow.borrow_amount
     *
     * @param borrowAmount the value for t_borrow.borrow_amount
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setBorrowAmount(Long borrowAmount) {
        this.borrowAmount = borrowAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_borrow.year_rate
     *
     * @return the value of t_borrow.year_rate
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public Integer getYearRate() {
        return yearRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_borrow.year_rate
     *
     * @param yearRate the value for t_borrow.year_rate
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setYearRate(Integer yearRate) {
        this.yearRate = yearRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_borrow.repayment_month
     *
     * @return the value of t_borrow.repayment_month
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public Integer getRepaymentMonth() {
        return repaymentMonth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_borrow.repayment_month
     *
     * @param repaymentMonth the value for t_borrow.repayment_month
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setRepaymentMonth(Integer repaymentMonth) {
        this.repaymentMonth = repaymentMonth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_borrow.bid_num
     *
     * @return the value of t_borrow.bid_num
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public Integer getBidNum() {
        return bidNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_borrow.bid_num
     *
     * @param bidNum the value for t_borrow.bid_num
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setBidNum(Integer bidNum) {
        this.bidNum = bidNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_borrow.total_interest
     *
     * @return the value of t_borrow.total_interest
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public Long getTotalInterest() {
        return totalInterest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_borrow.total_interest
     *
     * @param totalInterest the value for t_borrow.total_interest
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setTotalInterest(Long totalInterest) {
        this.totalInterest = totalInterest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_borrow.current_bid_amount
     *
     * @return the value of t_borrow.current_bid_amount
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public Long getCurrentBidAmount() {
        return currentBidAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_borrow.current_bid_amount
     *
     * @param currentBidAmount the value for t_borrow.current_bid_amount
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setCurrentBidAmount(Long currentBidAmount) {
        this.currentBidAmount = currentBidAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_borrow.current_bid_interest
     *
     * @return the value of t_borrow.current_bid_interest
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public Long getCurrentBidInterest() {
        return currentBidInterest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_borrow.current_bid_interest
     *
     * @param currentBidInterest the value for t_borrow.current_bid_interest
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setCurrentBidInterest(Long currentBidInterest) {
        this.currentBidInterest = currentBidInterest;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_borrow.bid_deadline
     *
     * @return the value of t_borrow.bid_deadline
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public Date getBidDeadline() {
        return bidDeadline;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_borrow.bid_deadline
     *
     * @param bidDeadline the value for t_borrow.bid_deadline
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setBidDeadline(Date bidDeadline) {
        this.bidDeadline = bidDeadline;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_borrow.bid_days
     *
     * @return the value of t_borrow.bid_days
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public Integer getBidDays() {
        return bidDays;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_borrow.bid_days
     *
     * @param bidDays the value for t_borrow.bid_days
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setBidDays(Integer bidDays) {
        this.bidDays = bidDays;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_borrow.apply_time
     *
     * @return the value of t_borrow.apply_time
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_borrow.apply_time
     *
     * @param applyTime the value for t_borrow.apply_time
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_borrow.publish_time
     *
     * @return the value of t_borrow.publish_time
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_borrow.publish_time
     *
     * @param publishTime the value for t_borrow.publish_time
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_borrow.create_time
     *
     * @return the value of t_borrow.create_time
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_borrow.create_time
     *
     * @param createTime the value for t_borrow.create_time
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}