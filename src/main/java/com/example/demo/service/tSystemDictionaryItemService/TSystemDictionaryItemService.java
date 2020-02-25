package com.example.demo.service.tSystemDictionaryItemService;

import com.example.demo.pojo.Page;
import com.example.demo.pojo.TSystemDictionaryItem;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface TSystemDictionaryItemService {
    List<TSystemDictionaryItem> selectAll() throws Exception;

    Integer getCount(String keyword,String parentId);

    Map<String,Object> getAll(String keyword,String parentId, Page page);

    int updataDictionaryItem(TSystemDictionaryItem tSystemDictionaryItem);

    int insertDictionaryItem(TSystemDictionaryItem tSystemDictionaryItem);
}
