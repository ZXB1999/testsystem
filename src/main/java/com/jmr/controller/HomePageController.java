package com.jmr.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Api("首页控制器")
@Controller
public class HomePageController {
    @ApiOperation("首页")
    @RequestMapping("/homepage")
    public String index(@CookieValue(value = "username",
            defaultValue = "Atta") String username) {
        if (username.equals("Atta")){
            return "login";
        }else{
            return "homepage";
        }
    }
}
