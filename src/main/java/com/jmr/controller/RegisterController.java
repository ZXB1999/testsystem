package com.jmr.controller;

import com.jmr.service.impl.LoginServiceImpl;
import com.jmr.service.impl.RegisterServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jmr.common.constant.Constants;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Api("注册控制器")
@Controller
public class RegisterController {

    @Autowired(required = false)
    private LoginServiceImpl loginService;
    @Autowired(required = false)
    private RegisterServiceImpl registerService;

    @ApiOperation("注册页面")
    @RequestMapping("/register")
    public String index() {
        return "register";
    }

    @ApiOperation("注册方法")
    @PostMapping("/signin")
    @ResponseBody
    public String register(String username, String password){
        if(username==""||password==""){
            return Constants.LOGIN_FAIL;
        }else if (loginService.Userexist(username)!=null){
            return "用户已存在";
        }else{
            registerService.registerUser(username, password);
            return Constants.LOGIN_SUCCESS;
        }
    }
}
