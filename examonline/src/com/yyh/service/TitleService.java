package com.yyh.service;

import com.yyh.pojo.Title;

import java.util.List;

/**
 * @Description: com.yyh.service
 * @version: 1.0
 */
public interface TitleService {
    void ins(Title title);

    void del(Title title);

    void delById(int tid);

    void upd(Title title);

    Title selById(int tid);

    List<Title> selAll();

    List<Title> selByCourseLevel(String course, int level);

    List<Title> selByCourse(String course);
}
