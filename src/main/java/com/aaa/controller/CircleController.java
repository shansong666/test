package com.aaa.controller;

import com.aaa.entity.Circle;
import com.aaa.entity.Clable;
import com.aaa.entity.Review;
import com.aaa.entity.User_info;
import com.aaa.service.CircleService;
import com.aaa.service.ClableService;
import com.aaa.service.ReviewService;
import com.aaa.service.User_infoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @Autowired
    ReviewService rs;
    @Autowired
    ClableService cls;
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
    public String testss(Model model){
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();

        /*这个是圈子的信息*/
        List<Circle> lc = cs.diffTime();
        //System.out.println(lc);
        //System.out.println(lc.get(0).getUserid());
        for (int i = 0; i < lc.size() ; i++) {
            Map<String,Object> circle = new HashMap<String,Object>();
            /*这个是获得用户的一些信息*/
            List<User_info> lus = us.queryByUserId(lc.get(i).getUserid());
            //System.out.println(lus);
            /*这个是获取评论信息的*/
            List<Review> lr = rs.queryByComposeid(lc.get(i).getCircleid());
            //System.out.println(lr);
            List<Clable> lcs = cls.queryByClableid(lc.get(i).getClableid());
            circle.put("username",lus.get(0).getUsername());
            circle.put("head",lus.get(0).getHead());
            circle.put("title",lc.get(i).getTitle());
            circle.put("content",lc.get(i).getContent());
            circle.put("clablename",lcs.get(0).getClablename());
            if(lr.size()==0){
                circle.put("rcount", 0);
            }else{
                List<User_info> lui = us.queryByUserId(lr.get(0).getUserid());
                circle.put("rname",lui.get(0).getUsername());
                circle.put("rtime",lr.get(0).getTime());
                circle.put("rcount",lr.size());
            }
            resultList.add(circle);
        }
        /*System.out.println(resultList.toString());*/
        model.addAttribute("circ",resultList);
        System.out.println(resultList.toString());
        return "cir";
    }
}
