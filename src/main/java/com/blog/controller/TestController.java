package com.blog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.blog.dao.test;
import com.blog.entity.Top50;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    public test testdao;

    @RequestMapping("test.do")
    public ModelAndView test(){
        List<Top50> list =  testdao.listAll();
        JSONArray array= JSONArray.parseArray(JSON.toJSONString(list));
        System.out.println(array.toJSONString());
        return new ModelAndView("index");
    }

    @RequestMapping(value = "getTop50.do",produces = "application/json;charset=UTF-8")
    public @ResponseBody String getTop50(){
        List<Top50> list =  testdao.listAll();
        JSONArray array= JSONArray.parseArray(JSON.toJSONString(list));
        return array.toJSONString();
    }
}
