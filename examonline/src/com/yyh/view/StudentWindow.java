package com.yyh.view;


import com.yyh.service.PaperService;
import com.yyh.service.UserService;
import com.yyh.service.impl.PaperServiceImpl;
import com.yyh.service.impl.UerServiceImpl;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * @Description: com.yyh.view
 * @version: 1.0
 */
public class StudentWindow extends JFrame {
    private PaperService paperService = new PaperServiceImpl();
    private UserService userService = new UerServiceImpl();
    int uid;
    String course;


    public StudentWindow(int uid, String course) {

        this.uid = uid;
        this.course = course;


        setIconImage(new ImageIcon("images/app.png").getImage());
        setSize(800, 470);
        setContentPane(createContentPane());
        Toolkit tool = Toolkit.getDefaultToolkit();
        Dimension win = tool.getScreenSize();
        int x = (int) (win.getWidth() / 2 - this.getWidth() / 2);
        int y = (int) (win.getHeight() / 2 - this.getHeight() / 2);
        this.setLocation(x, y);
        this.setVisible(true);

        try {
            Thread.sleep(3000);
            setVisible(false);
            new ExamWindow(uid, course);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private JPanel createContentPane() {
        JPanel p = new JPanel();
        JLabel l = new JLabel();
        p.setBorder(new LineBorder(Color.gray));
        p.add(l);
        return p;
    }
}
