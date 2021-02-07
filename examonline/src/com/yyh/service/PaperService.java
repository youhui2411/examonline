package com.yyh.service;

import com.yyh.pojo.Paper;

import java.util.List;

/**
 * @Description: com.yyh.service
 * @version: 1.0
 */
public interface PaperService {
    void ins(Paper paper);

    void del(Paper paper);

    void delById(int tid);

    void upd(Paper paper);

    void updIdCourse(int pid, String course, int userPoint);

    Paper selById(int pid);

    Boolean selByIdCourse(Paper paper);

    Paper selByIdCou(Paper paper);

    Paper isExam(Paper paper);

    List<Paper> selByCourse(String course);

    List<Paper> selAll();

    List<String> selCourse();
}
