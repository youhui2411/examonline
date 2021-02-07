package com.yyh.service.impl;

import com.yyh.mapper.PaperMapper;
import com.yyh.pojo.Paper;
import com.yyh.service.PaperService;
import com.yyh.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Description: com.yyh.service.impl
 * @version: 1.0
 */
public class PaperServiceImpl implements PaperService {

    private SqlSession session = MybatisUtil.getSession();
    private PaperMapper paperMapper = session.getMapper(PaperMapper.class);

    @Override
    public void ins(Paper paper) {
        int result = paperMapper.ins(paper);

        session.commit();
        if(result > 0){
            System.out.println("插入成功！");
        }else{
            System.out.println("插入失败！");
        }

    }

    @Override
    public void del(Paper paper) {
        paperMapper.del(paper);
        session.commit();

    }

    @Override
    public void delById(int tid) {
        paperMapper.delById(tid);
        session.commit();

    }

    @Override
    public void upd(Paper paper) {
        paperMapper.upd(paper);
        session.commit();
    }

    @Override
    public void updIdCourse(int pid, String course, int userPoint) {
        int result = paperMapper.updByIdCourse(pid, course, userPoint);
        session.commit();
        if(result > 0){
            System.out.println("更新成功！");
        }else{
            System.out.println("更新失败！");
        }
    }

    @Override
    public Paper selById(int pid) {
        Paper paper = paperMapper.selById(pid);

        return paper;
    }

    @Override
    public Boolean selByIdCourse(Paper paper) {
        Paper paper1 = paperMapper.selByIdCourse(paper);

        if(paper1 == null){
            return false;
        }else {
            return true;
        }

    }

    @Override
    public Paper selByIdCou(Paper paper) {
        Paper p = paperMapper.selByIdCourse(paper);
        return p;
    }

    @Override
    public Paper isExam(Paper paper) {
        return paperMapper.selByIdCourse(paper);
    }

    @Override
    public List<Paper> selByCourse(String course) {
        List<Paper> list = paperMapper.selByCourse(course);
        return list;
    }

    @Override
    public List<Paper> selAll() {
        List<Paper> list = paperMapper.selAll();
        System.out.println(list);
        return list;
    }

    @Override
    public List<String> selCourse() {
        List<String> course = paperMapper.selCourse();
        return course;
    }
}
