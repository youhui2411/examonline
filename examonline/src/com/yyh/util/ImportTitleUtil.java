package com.yyh.util;

import com.yyh.exception.StudentExistException;
import com.yyh.pojo.Title;
import com.yyh.service.TitleService;
import com.yyh.service.impl.TitleServiceImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: com.yyh.util
 * @version: 1.0
 */
public class ImportTitleUtil {

    private TitleService titleService = new TitleServiceImpl();

    public List<Title> getTitles() throws IOException {

        List<Title> list = new ArrayList<Title>();
        InputStreamReader isr = new InputStreamReader(new FileInputStream(new File("title.txt")));

        BufferedReader br = new BufferedReader(isr);

        String str = null;
        while (true) {
            str = br.readLine();
            if (str == null)
                break;
            String[] strTitle = str.split(":");
            Title title = new Title();
            System.out.println(Arrays.toString(strTitle));
            String question = strTitle[0];
            String toption = strTitle[1];
            String tkey = strTitle[2].trim();
            int level = Integer.parseInt(strTitle[3].trim());
            int score = Integer.parseInt(strTitle[4].trim());
            String course = strTitle[5];

            title.setQuestion(question);
            title.setToption(toption);
            title.setTkey(tkey);
            title.setLevel(level);
            title.setScore(score);
            title.setCourse(course);
            list.add(title);
        }
        isr.close();
        return list;
    }

    // 插入数据库
    public boolean insertTitle(List<Title> listTitle) throws StudentExistException {

        for (int i = 0; i < listTitle.size(); i++) {

            Title title = listTitle.get(i);
            titleService.ins(title);
        }
        return true;
    }
}
