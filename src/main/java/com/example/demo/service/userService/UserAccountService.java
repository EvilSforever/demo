package com.example.demo.service.userService;

import com.example.demo.pojo.RegisterUser;
import com.example.demo.pojo.TUserAccount;
import com.example.demo.pojo.TUserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserAccountService {

    boolean checkUserName(String name);

    boolean insertAccountUser(RegisterUser registerUser);

    /**
     * 用户注册
     * @param userName
     * @param password
     * @param accountType
     * @return
     * @throws Exception
     */
    TUserAccount userLogin(String userName,String password,Integer accountType,String ip)throws Exception;

    /**
     * 根据用户id查询信息
     * @param userId
     * @return
     * @throws Exception
     */
    TUserInfo selectAll(String userId)throws Exception;

    /**
     * 修改用户信息
     * @param tUserInfo
     * @return
     */
    int updateByPrimaryKeySelective(TUserInfo tUserInfo)throws Exception;
}
