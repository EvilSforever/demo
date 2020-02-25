package com.example.demo.constans;

import lombok.*;
import com.alibaba.fastjson.JSONObject;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ReturnResult {
    //结果状态码
    private int code;

    //结果信息
    private String msg;

    //结果数据
    private Object data;

    public String toString(){
        return JSONObject.toJSONString(this);
    }

    public ReturnResult(int code,String msg){
        this.code=code;
        this.msg=msg;
    }




}
