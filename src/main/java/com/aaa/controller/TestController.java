package com.aaa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("hello")
    public String hello(){
        System.out.println("访问index.html页面");
        return "index";
    }
}