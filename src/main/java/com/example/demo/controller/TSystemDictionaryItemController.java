package com.example.demo.controller;

import com.example.demo.constans.ResultCodeAndMsg;
import com.example.demo.constans.ReturnResult;
import com.example.demo.pojo.Page;
import com.example.demo.pojo.TSystemDictionaryItem;
import com.example.demo.service.tSystemDictionaryItemService.TSystemDictionaryItemService;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Log4j2
public class TSystemDictionaryItemController {

    @Autowired
    private TSystemDictionaryItemService tSystemDictionaryItemService;

    @RequestMapping(value = "/system/dictionaryItem/getAll",method = RequestMethod.GET)

    public ReturnResult seleAll(){
        ReturnResult returnResult=null;
        try {
            List<TSystemDictionaryItem> list= tSystemDictionaryItemService.selectAll();
            if (list.isEmpty()){
                returnResult=new ReturnResult(ResultCodeAndMsg.dateNull.getCode(),ResultCodeAndMsg.dateNull.getMsg());
            }else{
                returnResult=new ReturnResult(ResultCodeAndMsg.success.getCode(),ResultCodeAndMsg.success.getMsg(),list);
            }
            return returnResult;
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
            returnResult=new ReturnResult(ResultCodeAndMsg.exception.getCode(),ResultCodeAndMsg.exception.getMsg());
        }
        return returnResult;
    }
    @RequestMapping(value = "/system/dictionaryItem/query")
    public ReturnResult query(@RequestParam(value = "keyword",required = false)String name, @RequestParam(value = "parentId",required = false) String parentId, Page page){
        ReturnResult returnResult=null;
        Map<String,Object> map=new HashMap<>();
        try {
            map=tSystemDictionaryItemService.getAll(name, parentId, page);
            if (map!=null){
                returnResult=new ReturnResult(ResultCodeAndMsg.success.getCode(),ResultCodeAndMsg.success.getMsg(),map);
            }else{
                returnResult=new ReturnResult(ResultCodeAndMsg.dateNull.getCode(),ResultCodeAndMsg.dateNull.getMsg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnResult=new ReturnResult(ResultCodeAndMsg.exception.getCode(),ResultCodeAndMsg.exception.getMsg());
        }

        return returnResult;

    }
    @RequestMapping(value = "/system/dictionaryItem/update")
    public ReturnResult updata(TSystemDictionaryItem tSystemDictionaryItem){
        ReturnResult returnResult=null;
        int count=0;
        try {
            count=tSystemDictionaryItemService.updataDictionaryItem(tSystemDictionaryItem);
            if (count>0){
                returnResult=new ReturnResult(ResultCodeAndMsg.success.getCode(),ResultCodeAndMsg.success.getMsg());
            }else{
                returnResult=new ReturnResult(ResultCodeAndMsg.dateNull.getCode(),ResultCodeAndMsg.dateNull.getMsg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnResult=new ReturnResult(ResultCodeAndMsg.exception.getCode(),ResultCodeAndMsg.exception.getMsg());
        }
        return returnResult;
    }
    @RequestMapping(value = "/system/dictionaryItem/add")
    public ReturnResult add(TSystemDictionaryItem tSystemDictionaryItem){
        ReturnResult returnResult=null;
        int count=0;
        try {
            count=tSystemDictionaryItemService.insertDictionaryItem(tSystemDictionaryItem);
            if (count>0){
                returnResult=new ReturnResult(ResultCodeAndMsg.success.getCode(),ResultCodeAndMsg.success.getMsg());
            }else{
                returnResult=new ReturnResult(ResultCodeAndMsg.dateNull.getCode(),ResultCodeAndMsg.dateNull.getMsg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnResult=new ReturnResult(ResultCodeAndMsg.exception.getCode(),ResultCodeAndMsg.exception.getMsg());
        }
        return returnResult;
    }

}
