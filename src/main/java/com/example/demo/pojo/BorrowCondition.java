package com.example.demo.pojo;


import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.cache.NullCacheKey;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowCondition {
    private String beginDate;
    private String endDate;
    private String borrowStates;
    private String userId;

    //当前页码
    private Integer currentPage=1;
    //某条数据
    private Integer starNo=0;
    //显示数据
    private Integer pageSize=5;
    //总页数
    private Integer totalPage;
    //总记录数
    private Integer totalCont;

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
        if (currentPage>0){
            this.starNo = (currentPage-1)*pageSize;
        }
    }

    public void setTotalCont(Integer totalCont) {
        this.totalCont = totalCont;
        if (totalCont>0) {
            totalPage = (totalCont % pageSize) == 0 ? (totalCont / pageSize) : (totalCont / pageSize) + 1;
        }
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
