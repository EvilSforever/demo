package com.example.demo.service.tSystemDictionaryItemService;

import com.example.demo.dao.TSystemDictionaryItemMapper;
import com.example.demo.pojo.Page;
import com.example.demo.pojo.TSystemDictionaryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TSystemDictionaryItemServiceImpl implements TSystemDictionaryItemService {

    @Autowired
    private TSystemDictionaryItemMapper tSystemDictionaryItemMapper;

    @Override
    public List<TSystemDictionaryItem> selectAll() {
       List<TSystemDictionaryItem> list= tSystemDictionaryItemMapper.seleAll();
        return list;
    }

    @Override
    public Integer getCount(String keyword, String parentId) {
        return tSystemDictionaryItemMapper.getCount(keyword, parentId);
    }

    @Override
    public Map<String, Object> getAll(String keyword, String parentId, Page page) {
        Map<String, Object> map=new HashMap<>();
        List<TSystemDictionaryItem>list=tSystemDictionaryItemMapper.getAll(keyword, parentId, page);
        page.setStartPage(getCount(keyword, parentId));
        map.put("listData",list);
        map.put("totalPage",page.getTotalPages());
        map.put("currentPage",page.getStatNo());
        return map;
    }

    @Override
    public int updataDictionaryItem(TSystemDictionaryItem tSystemDictionaryItem) {
        return tSystemDictionaryItemMapper.updateByPrimaryKeySelective(tSystemDictionaryItem);
    }

    @Override
    public int insertDictionaryItem(TSystemDictionaryItem tSystemDictionaryItem) {
        return tSystemDictionaryItemMapper.insertSelective(tSystemDictionaryItem);
    }
}
