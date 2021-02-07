package com.yyh.service;

import com.yyh.exception.StudentExistException;
import com.yyh.pojo.User;

import java.util.List;

/**
 * @Description: com.yyh.service
 * @version: 1.0
 */
public interface UserService {
    void ins(User user)throws StudentExistException;

    void del(User user);

    void delById(int tid);

    void upd(User user);

    User selById(int uid);

    List<User> selAll();

}
