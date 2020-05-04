package com.blog.dao;

import com.blog.entity.BlogUser;

public interface UserDao {
    public BlogUser getOneUserByUserNameAndPassWd(BlogUser blogUser);

    public int addOneUser(BlogUser addOneUser);
}
