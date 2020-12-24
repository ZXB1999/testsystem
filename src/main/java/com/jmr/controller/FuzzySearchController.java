package com.jmr.controller;

import com.jmr.pojo.User;
import com.jmr.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Api("模糊查询")
@Controller
@ApiOperation("查询接口")
@RequestMapping("/search")
public class FuzzySearchController {
    @Autowired
    public UserServiceImpl userService;

    @ApiOperation("模糊查询接口")
    @ResponseBody
    @RequestMapping("/fuzzysearch")
    public ArrayList<String> index(@RequestParam (value="reson") String searchtext){
        ArrayList returnlist = new ArrayList();
        for (Object a:userService.FuzzySearch(searchtext)) {
            returnlist.add(((User)a).getUsername());
        }
        return returnlist;
    }
}
