package com.example.demo.dao;

import com.example.demo.pojo.Page;
import com.example.demo.pojo.TSystemDictionaryItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TSystemDictionaryItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_system_dictionary_item
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_system_dictionary_item
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    int insert(TSystemDictionaryItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_system_dictionary_item
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    int insertSelective(TSystemDictionaryItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_system_dictionary_item
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    TSystemDictionaryItem selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_system_dictionary_item
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    int updateByPrimaryKeySelective(TSystemDictionaryItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_system_dictionary_item
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    int updateByPrimaryKey(TSystemDictionaryItem record);

    List<TSystemDictionaryItem> seleAll();

    Integer getCount(@Param("keyword") String name,@Param("parentId") String parentId);

    List<TSystemDictionaryItem> getAll(@Param("keyword") String name,@Param("parentId") String parentId, @Param("page") Page page);
}