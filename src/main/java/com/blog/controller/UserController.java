package com.blog.controller;
import com.blog.entity.BlogUser;
import com.blog.public_content.PublicDefine;
import com.blog.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Data
public class UserController {
    @Autowired
    public BlogController bc;
    @Autowired
    public UserService us;

    @RequestMapping("login")
    public String loginPage(ModelMap mp){

        return "/projects/user/login";
    }

    @RequestMapping("tologin")
    public String login(ModelMap mp, HttpServletRequest request, BlogUser loginuser){
        //查询账号密码
        BlogUser getUser = us.getOneUserByUserNameAndPassWd(loginuser);
        if ( getUser == null){//用户不存在
            mp.addAttribute(PublicDefine.WARNING_PARAM_NAME,"账号密码错误");
            return "/projects/user/login";
        }

        request.getSession().setAttribute(PublicDefine.SESSION_LOGIN_USERNAME,getUser);//记录SESSION信息
        //用户存在
        return bc.blog(mp,request);//直接调用登录博客模块的博客显示控制器
    }

    //用户注册相关
    @RequestMapping("register")
    public String registerPageShow(){//展示用户注册界面
        return "/projects/user/register";
    }

    @RequestMapping("toRegister")
    public String toRegister(ModelMap mm,HttpServletRequest request ,
                             BlogUser registerUser){
        us.userRegister(registerUser);

        //注册完成后登录
        return this.login(mm,request,registerUser);
    }
}
