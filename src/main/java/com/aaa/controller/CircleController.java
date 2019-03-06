package com.aaa.controller;

import com.aaa.entity.Circle;
import com.aaa.entity.User_info;
import com.aaa.service.CircleService;
import com.aaa.service.User_infoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("circle")
public class CircleController {
    @Autowired
    CircleService cs;
    @Autowired
    User_infoService us;
    @RequestMapping("queryLimit")
    @ResponseBody
    public Map<String,Object> query(Integer page, Integer limit){
        return cs.query(page,limit);
    }
    @RequestMapping("query")
    @ResponseBody
    public List<Circle> queryAll(){
        System.out.println(cs.queryAll().size());
        System.out.println(cs.queryAll().get(0));
        return cs.queryAll();
    }


    @RequestMapping("circle")
    public String testss(){
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        Map<String,Object> circle = new HashMap<String,Object>();
        List<Circle> lc = cs.diffTime();
        System.out.println(lc);
        for (int i = 0; i < lc.size() ; i++) {
            List<User_info> lus = us.queryByUserId(lc.get(i).getUserid());


        }

        /*circle.put();*/
        return "cir";
    }


}
