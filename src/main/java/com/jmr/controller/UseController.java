package com.jmr.controller;

import com.jmr.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api("用户管理控制器")
@Controller
public class UseController {
    @Autowired(required = false)
    public UserServiceImpl userService;

    @ApiOperation("用户管理页面")
    @RequestMapping("/userlist")
    public String userlist(){
        return "userlist";
    }

    @ApiOperation("获取用户数据")
    @PostMapping("/user")
    @ResponseBody
    public Map index(){
        return userService.FindAllUser();
    }
}
