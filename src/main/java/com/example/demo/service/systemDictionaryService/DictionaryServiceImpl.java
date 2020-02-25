package com.example.demo.service.systemDictionaryService;

import com.example.demo.dao.TSystemDictionaryMapper;
import com.example.demo.pojo.Page;
import com.example.demo.pojo.TSystemDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private TSystemDictionaryMapper dictionaryMapper;


    @Override
    public Integer getQueryCount(String keyword, Page page) {
        int count=dictionaryMapper.getQueryCount(keyword,page);
        System.out.println("总数："+count);
        return count;
    }

    @Override
    public Map<String,Object> getQuery(String keywork, Page page) {
        Map<String,Object> map=new HashMap<>();
        List<TSystemDictionary> list=dictionaryMapper.getQuery(keywork,page);
        page.setStartPage(getQueryCount(keywork, page));
        map.put("listData",list);
        map.put("totalPage",page.getTotalPages());
        map.put("currentPage",page.getStatNo());

        return map;
    }

    @Override
    public int insertDictionary(TSystemDictionary tSystemDictionary) {
        int count=0;
        try {
            count=dictionaryMapper.insertSelective(tSystemDictionary);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("添加字典异常");
        }
        return count;
    }

    @Override
    public int updataDictionary(TSystemDictionary tSystemDictionary) {
        int count=0;
        try {
            count=  dictionaryMapper.updateByPrimaryKeySelective(tSystemDictionary);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("修改字典异常");
        }
        return count;
    }

    @Override
    public List<TSystemDictionary> getAll() {

        List<TSystemDictionary>list=dictionaryMapper.getAll();

        return list;
    }
}
