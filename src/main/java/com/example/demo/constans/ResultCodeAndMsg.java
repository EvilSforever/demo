package com.example.demo.constans;

import lombok.Getter;


public enum ResultCodeAndMsg {

    success(200,"成功"),
    fail(500,"失败"),
    exception(501,"异常"),
    userNameIsNull(502,"用户名为空"),
    userPasswordIsNull(503,"密码不能为空"),
    userNameOrPwdError(504,"账号或密码错误"),
    dateNull(505,"数据为空"),
    userIdNull(506,"用户id为空");

    private int code;
    private String msg;

    ResultCodeAndMsg(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
