package com.example.demo.service.systemDictionaryService;

import com.example.demo.pojo.Page;
import com.example.demo.pojo.TSystemDictionary;

import java.util.List;
import java.util.Map;

public interface DictionaryService {

    /**
     * 根据条件查询数量
     * @param keywork
     * @param page
     * @return
     */
    Integer getQueryCount(String keywork, Page page);

    /**
     * 模糊查询、分页
     * @param keywork
     * @param page
     * @return
     */
    Map<String,Object> getQuery(String keywork, Page page);

    int insertDictionary(TSystemDictionary tSystemDictionary);

    int updataDictionary(TSystemDictionary tSystemDictionary);

    List<TSystemDictionary> getAll();

}
