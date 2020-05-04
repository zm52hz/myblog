package com.blog.controller;

import com.blog.entity.BlogUser;
import com.blog.public_content.PublicDefine;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Data
public class BlogController {

    @Autowired
    public UserController uc;
    @RequestMapping("/")
    public String blog(ModelMap mp, HttpServletRequest request){
        BlogUser loginUser = (BlogUser) request.getSession().getAttribute(PublicDefine.SESSION_LOGIN_USERNAME);
        if (loginUser == null){
            return uc.loginPage(mp);
        }
        return "blog";
    }
}
