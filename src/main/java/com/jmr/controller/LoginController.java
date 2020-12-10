package com.jmr.controller;

import com.jmr.service.impl.LoginServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import com.jmr.common.constant.Constants;
/* 类注解 */
@Api("登录控制器")
@Controller
public class LoginController {
    private  final  static Logger logger = LoggerFactory.getLogger(LoginController.class);// 声明一个Logger，static方式
    @Autowired(required = false)
    private LoginServiceImpl loginService;

    /* 方法注解 */
    @ApiOperation("登陆页面")
    @RequestMapping("")
    public String index(/* 参数注解 */ @ApiParam(value = "desc of param" , required=true ) String name) {
        return "login";
    }

    @ApiOperation("登陆判断")
    @RequestMapping("/login")
    @ResponseBody
    public Map<String,String> index(String username, String password) {
        Map<String,String> map = new HashMap<String,String>();
        if(username==""||password==""){//验证用户名密码
            logger.error("error");
            map.put("code","2");
            return map;
        }else if(loginService.Finduser(username,password)!=null){
            logger.info(username+"->"+Constants.LOGIN_SUCCESS);
            map.put("code","1");
            return map;
        }else{
            logger.error(Constants.LOGIN_FAIL);
            map.put("code","2");
            return map;
        }
    }
}
