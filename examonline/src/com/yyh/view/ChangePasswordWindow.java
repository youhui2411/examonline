package com.yyh.view;

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
public class ChangePasswordWindow extends JFrame {



    private JPanel jPanel1;
    private JButton jButton1;
    private JLabel jLabel5;
    private JPasswordField jPasswordField2;
    private JPasswordField jPasswordField1;
    private JTextField jTextField2;
    private JLabel jLabel4;
    private JLabel jLabel3;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JButton jButton2;

    private UserService userService=new UerServiceImpl();

    public ChangePasswordWindow() {


        try {
            setIconImage(new ImageIcon("images/app.png").getImage());
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(null);

                jPanel1 = new JPanel();
                getContentPane().add(jPanel1);
                jPanel1.setBounds(0, 0, 485, 343);
                jPanel1.setLayout(null);

                    jButton1 = new JButton();
                    jPanel1.add(jButton1);
                    jButton1.setText("\u786e\u8ba4");
                    jButton1.setBounds(182, 261, 52, 30);


                    jButton2 = new JButton();
                    jPanel1.add(jButton2);
                    jButton2.setText("\u91cd\u7f6e");
                    jButton2.setBounds(282, 261, 52, 30);
                    jButton2.setOpaque(true);


                    jLabel2 = new JLabel();
                    jPanel1.add(jLabel2);
                    jLabel2.setText("       \u4fee\u6539\u5bc6\u7801");
                    jLabel2.setBounds(140, 20, 203, 45);
                    jLabel2.setOpaque(true);
                    jLabel2.setFont(new java.awt.Font("楷体",0,18));


                    jLabel1 = new JLabel();
                    jPanel1.add(jLabel1);
                    jLabel1.setText("\u8f93\u5165\u5b66\u53f7");
                    jLabel1.setBounds(93, 88, 77, 18);


                    jLabel3 = new JLabel();
                    jPanel1.add(jLabel3);
                    jLabel3.setText("\u8f93\u5165\u5b66\u53f7");
                    jLabel3.setBounds(93, 88, 77, 18);


                    jLabel4 = new JLabel();
                    jPanel1.add(jLabel4);
                    jLabel4.setText("\u8f93\u5165\u65b0\u5bc6\u7801");
                    jLabel4.setBounds(93, 198, 77, 18);


                    jTextField2 = new JTextField();
                    jPanel1.add(jTextField2);
                    jTextField2.setBounds(182, 82, 146, 30);


                    jLabel5 = new JLabel();
                    jPanel1.add(jLabel5);
                    jLabel5.setText("\u8f93\u5165\u539f\u5bc6\u7801");
                    jLabel5.setBounds(93, 142, 77, 18);


                    jPasswordField1 = new JPasswordField();
                    jPanel1.add(jPasswordField1);
                    jPasswordField1.setBounds(182, 140, 147, 28);


                    jPasswordField2 = new JPasswordField();
                    jPanel1.add(jPasswordField2);
                    jPasswordField2.setBounds(182, 189, 147, 28);





            pack();
            this.setSize(501, 376);
            setLocationRelativeTo(null);
            setVisible(true);
            jButton1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stube
                    int uid=Integer.parseInt(jTextField2.getText());
                    String password= MD5Util.md5(new String(jPasswordField1.getPassword()));
                    User user=userService.selById(uid);
                    if(password.equals(user.getPassword())){

                        String newPassword=MD5Util.md5(new String(jPasswordField2.getPassword()));
                        user.setPassword(newPassword);
                        userService.upd(user);
                        JOptionPane.showMessageDialog(ChangePasswordWindow.this,"恭喜:"+user.getUsername()+"你的密码修改成功");
                    }
                    else
                        JOptionPane.showMessageDialog(jButton1, "原始密码错误");
                }
            });
            jButton2.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    jPasswordField1.setText("");
                    jPasswordField2.setText("");

                }
            });
        } catch (Exception e) {
            //add your error handling code here
            e.printStackTrace();
        }



    }

}
