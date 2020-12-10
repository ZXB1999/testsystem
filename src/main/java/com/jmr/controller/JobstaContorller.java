package com.jmr.controller;

import com.jmr.service.JobstaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Api("企业统计控制器")
@Controller
public class JobstaContorller {
    @Autowired(required = false)
    private JobstaService jobstaService;

    /**
     * @author camel
     * @param model
     * @return
     */
    @ApiOperation("根据企业统计")
    @RequestMapping("/job")
    public String countsex(Model model)
    {
        for(int i=0;i<3;i++) {
            model.addAttribute("boy"+i, jobstaService.countsex(i));
        }
        for(int j=0;j<4;j++){
            model.addAttribute("history"+j,jobstaService.counthistory(j));
        }
        for(int k=0;k<6;k++){
            model.addAttribute("levle"+k,jobstaService.countlevel(k));
        }
        for(int q=0;q<6;q++){
            model.addAttribute("range"+q,jobstaService.countrange(q));
        }
        String  []a={"民营","国企","孵化器","新兴高企","外资","无"};
        for(int w=0;w<a.length;w++){
            model.addAttribute("remake"+w,jobstaService.countremark(a[w]));
        }
        return "Jobsta";
    }
  }













