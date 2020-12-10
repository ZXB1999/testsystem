package com.jmr.service.impl;

import com.jmr.dao.RegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl {
    @Autowired(required = false)
    public RegisterMapper registerMapper;

    public Integer registerUser(String username,String password) {
        return this.registerMapper.registerUser(username,password);
    }
}
