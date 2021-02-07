package com.yyh.service.impl;

import com.yyh.mapper.TitleMapper;
import com.yyh.pojo.Title;
import com.yyh.service.TitleService;
import com.yyh.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Description: com.yyh.service.impl
 * @version: 1.0
 */
public class TitleServiceImpl implements TitleService {

    private SqlSession session = MybatisUtil.getSession();
    private TitleMapper titleMapper = session.getMapper(TitleMapper.class);

    @Override
    public void ins(Title title) {
        titleMapper.ins(title);
        session.commit();

    }

    @Override
    public void del(Title title) {
        titleMapper.del(title);
        session.commit();

    }

    @Override
    public void delById(int tid) {
        titleMapper.delById(tid);
        session.commit();

    }

    @Override
    public void upd(Title title) {
        titleMapper.upd(title);
        session.commit();
    }

    @Override
    public Title selById(int tid) {
        Title title = titleMapper.selById(tid);

        return title;
    }

    @Override
    public List<Title> selAll() {
        List<Title> list = titleMapper.selAll();

        return list;
    }

    @Override
    public List<Title> selByCourseLevel(String course, int level) {
        List<Title> list = titleMapper.selByCourseLevel(course, level);
        return list;
    }

    @Override
    public List<Title> selByCourse(String course) {
        List<Title> list = titleMapper.selByCourse(course);

        return list;
    }
}
