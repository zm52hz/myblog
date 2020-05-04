package com.blog.entity;

import lombok.Data;

@Data
public class BlogUser {
    public String id;
    public String user_realname;
    public String user_call;
    public String user_name;
    public String user_passwd;
    public String user_comment;
    public String user_phone;

    public BlogUser(String user_name ,String user_passwd){
        this.user_name = user_name;
        this.user_passwd = user_passwd;//MD5操作
    }
    public BlogUser(){

    }
}
