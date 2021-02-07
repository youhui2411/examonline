package com.yyh.service.impl;

import com.yyh.exception.StudentExistException;
import com.yyh.mapper.UserMapper;
import com.yyh.pojo.User;
import com.yyh.service.UserService;
import com.yyh.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Description: com.yyh.service.impl
 * @version: 1.0
 */
public class UerServiceImpl implements UserService {

    private SqlSession session = MybatisUtil.getSession();
    private UserMapper userMapper = session.getMapper(UserMapper.class);


    @Override
    public void ins(User user) throws StudentExistException {
        userMapper.ins(user);
        session.commit();
    }

    @Override
    public void del(User user) {
        userMapper.del(user);
        session.commit();

    }

    @Override
    public void delById(int tid) {
        userMapper.delById(tid);
        session.commit();

    }

    @Override
    public void upd(User user) {
        userMapper.upd(user);
        session.commit();

    }

    @Override
    public User selById(int uid) {
        User user = userMapper.selById(uid);

        return user;
    }

    @Override
    public List<User> selAll() {
        List<User> list = userMapper.selAll();

        return list;
    }
}
