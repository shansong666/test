package com.aaa.controller;

import com.aaa.entity.User_Info;
import com.aaa.service.User_InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("user")
public class TestController {
    @Autowired
    User_InfoService us;

    @RequestMapping("hello")
    public String hello(){
        System.out.println("访问index.html页面");
        System.out.println("贼帅 修改");
        return "index";
    }

    @RequestMapping("query")
    public String query(Model model){
        List<User_Info> list = us.query();
        model.addAttribute("list",list);
        return "success";
    }
}