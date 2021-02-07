package com.yyh.mapper;

import com.yyh.pojo.User;

import java.util.List;

/**
 * @Description: com.com.yyh.mapper
 * @version: 1.0
 */
public interface UserMapper {
    int ins(User user);
    int delById(int tid);
    int del(User user);
    int upd(User user);
    User selById(int uid);
    List<User> selAll();
}
