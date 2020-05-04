package com.blog.service;

import com.blog.dao.UserDao;
import com.blog.entity.BlogUser;
import com.blog.util.StringUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    public UserDao ud;

    //根据用户名密码获取用户信息
    public BlogUser getOneUserByUserNameAndPassWd(BlogUser bloguser){
        //密码做MD5设置
        String passwd = bloguser.getUser_passwd();
        String passwd_md5 = StringUtils.stringToMD5(passwd);
        bloguser.setUser_passwd(passwd_md5);

        return ud.getOneUserByUserNameAndPassWd(bloguser);
    }

    //用户注册
    public int userRegister(BlogUser registerUser){
        //用户名称做一个MD5操作 给ID信息
        String username = registerUser.getUser_name();
        String username_MD5 = StringUtils.stringToMD5(username);
        registerUser.setId(username_MD5);
        //密码做MD5操作
        String userpasswd = registerUser.getUser_passwd();
        String userpasswd_MD5 = StringUtils.stringToMD5(userpasswd);
        registerUser.setUser_passwd(userpasswd_MD5);

        return ud.addOneUser(registerUser);
    }
}
