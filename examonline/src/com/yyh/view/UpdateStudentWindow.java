package com.yyh.view;

import com.yyh.pojo.Paper;
import com.yyh.pojo.User;
import com.yyh.service.UserService;
import com.yyh.service.impl.UerServiceImpl;
import com.yyh.util.MD5Util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description: com.yyh.view
 * @version: 1.0
 */
public class UpdateStudentWindow extends JFrame {

    private JButton jButton1;
    private JLabel jLabel2;
    private JTextField jTextField4;
    private JTextField jTextField3;
    private JTextField jTextField2;
    private JTextField jTextField1;
    private JButton jButton2;
    private JLabel jLabel10;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JPanel jPanel1;
    private User user;
    private int paper;

    // 注入UserManage
    private static UserService userService = new UerServiceImpl();

    public UpdateStudentWindow(User user, int paper2) {
        this.user = user;
        this.paper = paper2;



        try {
            setIconImage(new ImageIcon("images/app.png").getImage());
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                jPanel1 = new JPanel();
                jPanel1.setLayout(null);

                    jLabel7 = new JLabel();
                    jPanel1.add(jLabel7);
                    jLabel7.setText("\u5b66\u751f\u59d3\u540d");
                    jLabel7.setBounds(135, 126, 68, 17);


                    jButton1 = new JButton();
                    jPanel1.add(jButton1);
                    jButton1.setText("修改");//修改
                    jButton1.setBounds(238, 302, 67, 24);


                    jButton2 = new JButton();
                    jPanel1.add(jButton2);
                    jButton2.setText("清空");//清空
                    jButton2.setBounds(351, 302, 68, 24);


                    jLabel8 = new JLabel();
                    jPanel1.add(jLabel8);
                    jLabel8.setText("学生密码");//学生密码
                    jLabel8.setBounds(135, 184, 68, 17);


                    jLabel10 = new JLabel();
                    jPanel1.add(jLabel10);
                    jLabel10.setText("试卷编号");//试卷编号
                    jLabel10.setBounds(135, 246, 68, 17);
                    jLabel10.setOpaque(true);


                    jLabel2 = new JLabel();
                    jPanel1.add(jLabel2);
                    jLabel2.setText("学生编号");//学生编号
                    jLabel2.setBounds(135, 66, 91, 17);


                    jTextField1 = new JTextField();
                    jPanel1.add(jTextField1);
                    jTextField1.setText(user.getUid() + "");
                    jTextField1.setEditable(false);
                    jTextField1.setBounds(238, 66, 181, 24);


                    jTextField2 = new JTextField();
                    jPanel1.add(jTextField2);
                    jTextField2.setText(user.getUsername());
                    jTextField2.setEditable(false);
                    jTextField2.setBounds(238, 123, 181, 24);


                    jTextField3 = new JTextField();
                    jPanel1.add(jTextField3);
                    jTextField3.setText(user.getPassword());
                    jTextField3.setBounds(236, 184, 181, 23);


                    jTextField4 = new JTextField();
                    jPanel1.add(jTextField4);
                    jTextField4.setText(paper + "");
                    jTextField4.setEditable(false);
                    jTextField4.setBounds(238, 243, 181, 23);


            pack();
            this.setSize(552, 391);

            setLocationRelativeTo(null);
            setVisible(true);
            jTextField1.setEditable(false);
            jTextField4.setEditable(false);
            GroupLayout groupLayout = new GroupLayout(getContentPane());
            groupLayout.setHorizontalGroup(
                    groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 562, GroupLayout.PREFERRED_SIZE)
            );
            groupLayout.setVerticalGroup(
                    groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 458, GroupLayout.PREFERRED_SIZE)
            );
            getContentPane().setLayout(groupLayout);

            // 修改密码事件
            jButton1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    String name = jTextField2.getText();
                    String password = MD5Util.md5(jTextField3.getText());
                    User user1 = new User();
                    user1.setUid(user.getUid());
                    user1.setUsername(name);
                    user1.setPassword(password);

                    if (paper == 0) {
                        userService.upd(user1);
                    } else {
                        user1.setPaperId(paper);
                        userService.upd(user1);
                    }
                    JOptionPane
                            .showMessageDialog(UpdateStudentWindow.this, "update success!!!");
                }
            });
        } catch (Exception e) {
            // add your error handling code here
            e.printStackTrace();
        }

        jButton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField3.setText("");

            }
        });


    }
}
