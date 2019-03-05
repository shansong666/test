package com.aaa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("hello")
    public String hello(){
        System.out.println("访问index.html页面");
        return "index";
    }
    @RequestMapping("circle")
    public String teests(){
        System.out.println("测试方法");
        return "cir";
    }
    @RequestMapping(value="{name}")
    public String tiaozhuan(@PathVariable String name){
        return  name;
    }
}