package com.jmr.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Api("模糊查询")
@Controller
@ApiOperation("查询接口")
@RequestMapping("/search")
public class FuzzySearchController {
    @ApiOperation("模糊查询接口")
    @RequestMapping("/fuzzysearch")
    public void index(String searchtext){
        System.out.println(searchtext);
    }
}
