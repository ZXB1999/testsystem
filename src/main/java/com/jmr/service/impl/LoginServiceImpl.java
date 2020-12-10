package com.jmr.service.impl;

import com.jmr.dao.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl {
    @Autowired(required = false)
    private LoginMapper loginMapper;
    //登录验证
    public String Finduser(String username,String password){
        return this.loginMapper.findUser(username,password);
    }
    //注册验证
    public String Userexist(String username){
        return this.loginMapper.userExist(username);
    }

}
