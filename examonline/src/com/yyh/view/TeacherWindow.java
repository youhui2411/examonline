package com.yyh.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @Description: com.yyh.view
 * @version: 1.0
 */
public class TeacherWindow extends JFrame {


    private JMenuBar jMenuBar1;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenu jMenu3;
    private JMenu jMenu4;
    private JMenu jMenu5;
    private JLabel jLabel1;

    public TeacherWindow(){

        //设置一下主题
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        setIconImage(new ImageIcon("images/app.png").getImage());
        setTitle("管理员界面");

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int var = JOptionPane.showConfirmDialog(TeacherWindow.this, "确定离开吗?", "请确认", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (var == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        jMenuBar1 = new JMenuBar();
        jMenuBar1.setBackground(Color.WHITE);
        jMenu1 = new JMenu();
        jMenu2 = new JMenu();
        jMenu3 = new JMenu();
        jMenu4 = new JMenu();
        jMenu5 = new JMenu();

        jMenu1.setText("题目管理");//题目管理

        // 增加对题目管理的事件
        jMenu1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                new TitleManageWindow();

            }
        });


        jMenu2.setText("学生管理");//学生管理
        jMenu2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new StudentManageWindow();
            }
        });



        jMenu3.setText("试卷管理");//试卷管理
        jMenu3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new CreatePaperWindow();
            }
        });

        jMenu4.setText("成绩管理");//成绩管理
        jMenu4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new GradeManageWindow();
            }
        });



        jMenu5.setText("退出");//退出

        jMenu5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);
        jMenuBar1.add(jMenu3);
        jMenuBar1.add(jMenu4);
        jMenuBar1.add(jMenu5);
        setJMenuBar(jMenuBar1);

        jLabel1 = new JLabel();
        jLabel1.setBackground(Color.WHITE);

        jLabel1.setIcon(new ImageIcon("images/TeacherWindow.png"));

        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 695, Short.MAX_VALUE)
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 458, Short.MAX_VALUE)
        );
        getContentPane().setLayout(groupLayout);
        pack();
        // 置中
        this.setLocationRelativeTo(null);
        // 固定大小
        setResizable(false);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TeacherWindow();
    }
}
