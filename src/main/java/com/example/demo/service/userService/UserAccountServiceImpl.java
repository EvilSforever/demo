package com.example.demo.service.userService;

import com.example.demo.constans.AccountConstants;
import com.example.demo.constans.SystemLimitConst;
import com.example.demo.dao.TLoginLogMapper;
import com.example.demo.dao.TUserAccountMapper;
import com.example.demo.dao.TUserInfoMapper;
import com.example.demo.dao.TUserWalletMapper;
import com.example.demo.pojo.*;
import com.example.demo.util.MD5;
import com.example.demo.util.MyUtil;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;


import java.util.Date;
import java.util.UUID;

@Service
@Log4j2
public class UserAccountServiceImpl implements UserAccountService {



    @Autowired
    private TUserAccountMapper userAccountMapper;

    @Autowired
    private TUserInfoMapper userInfoMapper;

    @Autowired
    private TLoginLogMapper tLoginLogMapper;



    @Autowired
    private TUserWalletMapper userWalletMapper;

    @Override
    public boolean checkUserName(String name) {
         TUserAccount tUserAccount=userAccountMapper.selectUserAccountUserName(name);
         if (tUserAccount==null){return true;}
        return false;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean insertAccountUser(RegisterUser registerUser) {
        int result = 0;
        try {
            TUserAccount userAccount = new TUserAccount();
            userAccount.setUsername(registerUser.getUserNmae());
            userAccount.setPassword(MD5.encode(registerUser.getPassword()));
            //生成用户ID，使用UUID工具随机生成
            userAccount.setId(UUID.randomUUID().toString().replace("-",""));
            //用户账号状态
            userAccount.setAccountStatus(AccountConstants.ACCOUNT_STATUS_ACTIVE);
            //用户账号类型
            userAccount.setAccountType(AccountConstants.ACCOUNT_TYPE_NOMAL);
            userAccount.setCreateTime(new Date());
            //执行用户新增操作
            result = userAccountMapper.insertSelective(userAccount);

            /*给新用户送钱*/
            TUserInfo userInfo = new TUserInfo();
            userInfo.setAccountId(userAccount.getId());
            userInfo.setAvatar("nobody.jpg");

            userInfoMapper.insertSelective(userInfo);

            //初始化用户钱包
            TUserWallet userWallet = new TUserWallet();
            userWallet.setAccountId(userAccount.getId());
            //加入10000元的体验金
            userWallet.setAvailableAmount(10000* SystemLimitConst.MONEY_UNIT);

            userWalletMapper.insertSelective(userWallet);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            //手动回滚事务

            throw new RuntimeException(e);
        }

        if (result > 0) {
            return true;
        } else {
            return false;
        }

    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public TUserAccount userLogin(String userName, String password,Integer accountType,String ip) throws Exception {
        TUserAccount userAccount=null;
        TLoginLog tLoginLog=null;

        try {
            //验证
            userAccount= userAccountMapper.selectUserAccountUserName(userName);
            if (userAccount.getUsername()==null){
                /*用户不存在、记录日志*/
                tLoginLog=new TLoginLog();
                //登录ip
                tLoginLog.setIp(ip);
                //登录时间
                tLoginLog.setLoginTime(new Date());
                //登录用户名
                tLoginLog.setUsername(userAccount.getUsername());
                //账户类型
                tLoginLog.setAccountType(accountType);
                //登录结果
                tLoginLog.setLoginResult(0);
                //创建时间
                tLoginLog.setCreateTime(new Date());
                return null;
            }else{
                //更新最后时间
                if (userAccount.getPassword().equals(password)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    userAccount.setLastLoginDate(sdf.format(new Date()));
                    tLoginLog=new TLoginLog();
                    //用户ip
                    tLoginLog.setIp(ip);
                    //登录时间
                    tLoginLog.setLoginTime(new Date());

                    //登录用户名
                    tLoginLog.setUsername(userAccount.getUsername());
                    //账户类型
                    tLoginLog.setAccountType(accountType);
                    //登录结果
                    tLoginLog.setLoginResult(1);
                    //创建时间
                    tLoginLog.setCreateTime(new Date());
                    return userAccount;
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw  new Exception(e);
        }finally {
            int count=0;
            try {
                count= tLoginLogMapper.insertSelective(tLoginLog);
                if (count>0){
                    System.out.println("日志记录成功");
                }else{
                    System.out.println("日志记录失败");
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("日志记录失败");
                throw new RuntimeException();
            }
        }
    }

    private TUserAccount getUserAccountByUserName(String userName){
        return userAccountMapper.selectUserAccountUserName(userName);
    }

    @Override
    public TUserInfo selectAll(String userId) throws Exception {
        //查询用户信息
        return userAccountMapper.seleAll(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(TUserInfo tUserInfo) {
        //修改用户信息
        return userInfoMapper.updateByPrimaryKeySelective(tUserInfo);
    }
}
