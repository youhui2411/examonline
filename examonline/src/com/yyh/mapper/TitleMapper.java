package com.yyh.mapper;

import com.yyh.pojo.Title;

import java.util.List;

/**
 * @Description: com.yyh.mapper
 * @version: 1.0
 */
public interface TitleMapper {
    int ins(Title title);
    int del(Title title);
    int delById(int tid);
    int upd(Title title);
    Title selById(int tid);
    List<Title> selAll();
    List<Title> selByCourseLevel(String course, int level);
    List<Title> selByCourse(String course);
}
