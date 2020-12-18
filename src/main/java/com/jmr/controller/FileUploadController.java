package com.jmr.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;


@Api("文件上传")
@Controller
public class FileUploadController {
    @ApiOperation("文件上传页面")
    @RequestMapping("/uploadpage")
    public String index() {
        return "fileupload";
    }

    @ApiOperation("文件上传请求")
    @RequestMapping("/upload")
    @ResponseBody
    public void indexUplaod(@RequestParam(value="file") MultipartFile[] file1) throws IOException {
        for (MultipartFile f:file1) {
            System.out.println(f.getOriginalFilename());
            InputStream InputStream =f.getInputStream();
            byte[] buffer= FileCopyUtils.copyToByteArray(InputStream);
            System.out.println(buffer);
        }
        System.out.println(file1.length);
    }
}
