package com.example.demo.controller;

import com.example.demo.constans.ResultCodeAndMsg;
import com.example.demo.constans.ReturnResult;
import com.example.demo.pojo.Page;
import com.example.demo.pojo.TSystemDictionary;
import com.example.demo.service.systemDictionaryService.DictionaryService;
import lombok.extern.log4j.Log4j2;
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
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @RequestMapping(value = "/system/dictionary/query",method = RequestMethod.POST)
    public ReturnResult query(@RequestParam(value = "keyword",required = false)String name,Page page){
        ReturnResult returnResult=null;
        page.setStatNo(page.getCurrentPage());
        Map<String,Object> map = new HashMap<>();
        try {
            map=dictionaryService.getQuery(name,page);
            if (map!=null){
                returnResult=new ReturnResult(ResultCodeAndMsg.success.getCode(),ResultCodeAndMsg.success.getMsg(),map);
            }else{
                returnResult=new ReturnResult(ResultCodeAndMsg.dateNull.getCode(),ResultCodeAndMsg.dateNull.getMsg());
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
            returnResult=new ReturnResult(ResultCodeAndMsg.exception.getCode(),ResultCodeAndMsg.exception.getMsg());
        }
        return returnResult;
    }

    @RequestMapping(value = "/system/dictionary/add")
    public ReturnResult add(TSystemDictionary tSystemDictionary){
        ReturnResult returnResult=null;
        int count=0;
        try {
            count= dictionaryService.insertDictionary(tSystemDictionary);
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

    @RequestMapping(value = "/system/dictionary/update")
    public ReturnResult updata(TSystemDictionary tSystemDictionary){
        ReturnResult returnResult=null;
        int count=0;
        try {
            count=dictionaryService.updataDictionary(tSystemDictionary);
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
    @RequestMapping(value = "/system/dictionary/getAll")
    public ReturnResult getAll(){
        ReturnResult returnResult=null;
        try {
            List<TSystemDictionary> list=dictionaryService.getAll();
            if (list!=null){
                returnResult=new ReturnResult(ResultCodeAndMsg.success.getCode(),ResultCodeAndMsg.success.getMsg(),list);
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
