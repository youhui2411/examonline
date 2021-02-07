package com.yyh.test;

import com.yyh.mapper.PaperMapper;
import com.yyh.mapper.TitleMapper;
import com.yyh.mapper.UserMapper;
import com.yyh.pojo.Paper;
import com.yyh.pojo.Title;
import com.yyh.pojo.User;
import com.yyh.service.PaperService;
import com.yyh.service.UserService;
import com.yyh.service.impl.PaperServiceImpl;
import com.yyh.service.impl.UerServiceImpl;
import com.yyh.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Description: com.yyh.test
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        PaperService paperService = new PaperServiceImpl();
        List<Paper> list = paperService.selAll();
        for (Paper p:
             list) {
            System.out.println(p);
        }


//        UserService userService = new UerServiceImpl();
//        List<User> users = userService.selAll();
//        for (User u:
//             users) {
//            System.out.println(u);
//        }


//        UserService userService = new UerServiceImpl();
//        User u = new User();
//        u.setUid(1001);
//        u.setPassword("e10adc3949ba59abbe56e057f20f883e");
//        Paper paper = new Paper();
//        paper.setPid(1003);
//        u.setPaper(paper);
//        u.setStatus(1);
//        userService.upd(u);

//        PaperService paperService = new PaperServiceImpl();
//        List<Paper> papers = paperService.selAll();
//        for (Paper p: papers) {
//            System.out.println(p);
//        }


    }
}
