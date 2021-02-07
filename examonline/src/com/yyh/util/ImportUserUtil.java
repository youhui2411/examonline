package com.yyh.util;

import com.yyh.exception.StudentExistException;
import com.yyh.pojo.Paper;
import com.yyh.pojo.User;
import com.yyh.service.UserService;
import com.yyh.service.impl.UerServiceImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: com.yyh.util
 * @version: 1.0
 */
public class ImportUserUtil {

    private UserService userService = new UerServiceImpl();

    public List<User> getStudents() throws IOException {

        List<User> list = new ArrayList<User>();
        InputStreamReader isr = new InputStreamReader(new FileInputStream(new File("user.txt")));

        BufferedReader br = new BufferedReader(isr);

        String str = null;
        while (true) {

            str = br.readLine();
            if (str == null)
                break;
            String[] strUser = str.split(":");
            User user = new User();

            String name = strUser[0];
            String password = MD5Util.md5(strUser[1]);
            int status = Integer.parseInt(strUser[2]);

            user.setUsername(name);
            user.setPassword(password);
            user.setStatus(status);
            list.add(user);
        }
        isr.close();
        return list;
    }

    // 插入数据库
    public boolean insertUser(List<User> listUser) throws StudentExistException {

        for (int i = 0; i < listUser.size(); i++) {

            User user = listUser.get(i);
            userService.ins(user);
        }
        return true;
    }

}
