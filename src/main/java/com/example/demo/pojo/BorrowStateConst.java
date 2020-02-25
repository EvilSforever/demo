package com.example.demo.pojo;

/**
 * '借款状态' 常量类
 *
 * @author Kival
 */
public class BorrowStateConst {

    /** 撤销 **/
    public static final int UNDO = 0;

    /** 发布审核中 **/
    public static final int PUBLISH_PENDING = 10;

    /** 发布审核拒绝 **/
    public static final int PUBLISH_AUDIT_REJECT = 11;

    /** 发布审核通过 **/
    public static final int PUBLISH_AUDIT_PASS = 12;

    /** 招标中 **/
    public static final int BIDDING = 20;

    /** 流标 **/
    public static final int OVERDUE = 21;

    /** 放款审核中 **/
    public static final int LOAN_PENDING = 30;

    /** 放款审核拒绝 **/
    public static final int LOAN_AUDIT_REJECT = 31;

    /** 放款审核通过 **/
    public static final int LOAN_AUDIT_PASS = 32;

    /** 还款中 **/
    public static final int REPAYMENT = 40;

    /** 已还清 **/
    public static final int REPAYMENT_CLEARED = 50;

}
