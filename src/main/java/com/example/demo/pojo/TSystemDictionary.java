package com.example.demo.pojo;

import java.util.Date;

public class TSystemDictionary {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_system_dictionary.id
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_system_dictionary.code
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private String code;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_system_dictionary.name
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_system_dictionary.create_time
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_system_dictionary.id
     *
     * @return the value of t_system_dictionary.id
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_system_dictionary.id
     *
     * @param id the value for t_system_dictionary.id
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_system_dictionary.code
     *
     * @return the value of t_system_dictionary.code
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_system_dictionary.code
     *
     * @param code the value for t_system_dictionary.code
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_system_dictionary.name
     *
     * @return the value of t_system_dictionary.name
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_system_dictionary.name
     *
     * @param name the value for t_system_dictionary.name
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_system_dictionary.create_time
     *
     * @return the value of t_system_dictionary.create_time
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_system_dictionary.create_time
     *
     * @param createTime the value for t_system_dictionary.create_time
     *
     * @mbg.generated Fri Oct 11 11:28:27 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}