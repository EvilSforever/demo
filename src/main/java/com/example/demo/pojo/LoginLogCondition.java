package com.example.demo.pojo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class LoginLogCondition {
    private String beginDate;
    private String endDate;
    private String username;
    private Integer loginResult;


    //当前页码
    private Integer currentPage=1;
    //某条数据
    private Integer starNo;
    //显示数据
    private Integer pageSize=5;
    //总页数
    private Integer totalPage;
    //总记录数
    private Integer totalCont;

    public Integer getStarNo(){
        return (currentPage-1)*pageSize;
    }
    public void setStarNo(Integer starNo){this.starNo=starNo;}
    public Integer getTotalPage(){
        return (totalCont % pageSize)==0?(totalCont/pageSize):(totalCont/pageSize)+1;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}

