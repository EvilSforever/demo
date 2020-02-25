package com.example.demo.controller;

import com.example.demo.constans.ResultCodeAndMsg;
import com.example.demo.constans.ReturnResult;
import com.example.demo.constans.SystemPathConst;
import com.example.demo.pojo.TUserAccount;
import com.example.demo.pojo.TUserInfo;
import com.example.demo.service.userService.UserAccountService;
import com.example.demo.util.UploadUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@Log4j2
public class UserInfoController {

    @Autowired
    private UserAccountService userAccountService;

    @RequestMapping(value = "/user/userinfo/uploadAvatar",method = RequestMethod.POST)
    public ReturnResult uploooadAvatar(MultipartFile file){
        ReturnResult returnResult=new ReturnResult();
        //调用文件上传方法
        try {
            String  filenName= UploadUtil.uploadFile(file, SystemPathConst.UPLOAD_IMAGE_PATH);
            returnResult=new ReturnResult(ResultCodeAndMsg.success.getCode(),ResultCodeAndMsg.success.getMsg(),filenName);
        } catch (IOException e) {
            e.printStackTrace();
            returnResult=new ReturnResult(ResultCodeAndMsg.exception.getCode(),ResultCodeAndMsg.exception.getMsg());
        }

        return returnResult;
    }

    @RequestMapping(value = "/user/userinfo/get/{userId}",method = RequestMethod.GET)
    public ReturnResult seleAll(@PathVariable String userId){
        ReturnResult returnResult=null;
        try {
            if (userId.isEmpty()){
                //如果id为空
                returnResult =new ReturnResult(ResultCodeAndMsg.userIdNull.getCode(),ResultCodeAndMsg.userIdNull.getMsg());
            }else {
                //将数映射到实体类
                TUserInfo tUserInfo = userAccountService.selectAll(userId);
                if (tUserInfo == null) {
                    //如果实体类为空
                    returnResult=new ReturnResult(ResultCodeAndMsg.dateNull.getCode(), ResultCodeAndMsg.dateNull.getMsg());
                } else {
                    //将实体类存入returnResult
                    returnResult = new ReturnResult(ResultCodeAndMsg.success.getCode(), ResultCodeAndMsg.success.getMsg(), tUserInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnResult=new ReturnResult(ResultCodeAndMsg.exception.getCode(),ResultCodeAndMsg.exception.getMsg());
            log.error(e.getMessage(),e);
        }
            return returnResult;
    }

    @RequestMapping(value = "/user/userinfo/update",method = RequestMethod.POST)
    public ReturnResult updataUserInfo(TUserInfo tUserInfo){
        ReturnResult returnResult=null;
        try {
            if (tUserInfo.getAvatar()!=null &&
                tUserInfo.getRealname()!=null &&
                tUserInfo.getIdCardNumber()!=null &&
                tUserInfo.getPhoneNumber()!=null &&
                tUserInfo.getIncomeLevelId()!=null &&
                tUserInfo.getMarriageId()!=null &&
                tUserInfo.getEduBackgroundId()!=null &&
                tUserInfo.getHouseConditionId()!=null){
                int count=userAccountService.updateByPrimaryKeySelective(tUserInfo);
                if (count>0){
                    returnResult=new ReturnResult(ResultCodeAndMsg.success.getCode(),ResultCodeAndMsg.success.getMsg(),tUserInfo);

                }else{
                    returnResult=new ReturnResult(ResultCodeAndMsg.dateNull.getCode(),ResultCodeAndMsg.dateNull.getMsg(),tUserInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
            returnResult=new ReturnResult(ResultCodeAndMsg.exception.getCode(),ResultCodeAndMsg.exception.getMsg(),tUserInfo);
        }
        return returnResult;
    }
}
