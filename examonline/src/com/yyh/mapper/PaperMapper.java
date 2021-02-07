package com.yyh.mapper;

import com.yyh.pojo.Paper;

import java.util.List;

/**
 * @Description: com.yyh.mapper
 * @version: 1.0
 */
public interface PaperMapper {
    int ins(Paper paper);
    int delById(int tid);
    int del(Paper paper);
    int upd(Paper paper);
    int updByIdCourse(int pid, String course, int userPoint);
    Paper selById(int pid);
    Paper selByIdCourse(Paper paper);
    List<Paper> selByCourse(String Course);
    List<Paper> selAll();
    List<String> selCourse();
}
