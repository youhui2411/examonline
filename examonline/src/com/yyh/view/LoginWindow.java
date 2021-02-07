package com.yyh.view;

import com.yyh.pojo.User;
import com.yyh.service.UserService;
import com.yyh.service.impl.UerServiceImpl;
import com.yyh.util.MD5Util;
import com.yyh.util.VeriCodeUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @Description: com.yyh.view
 * @version: 1.0
 */
public class LoginWindow extends JFrame {

    private JButton jButton1;
    private JButton jButton2;
    private JLabel jlabel;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JTextField jTextField;
    private JTextField jTextField1;
    private JPasswordField jPasswordField;
    private JPanel jPanel;
    private String veriCode;//验证码


    private UserService userService = new UerServiceImpl();

    public LoginWindow() {

        //设置一下主题
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        setIconImage(new ImageIcon("images/app.png").getImage());
        setTitle("非凡在线考试系统");

        jlabel = new JLabel();
        jlabel.setIcon(new ImageIcon("images/login.png"));
        jlabel.setBounds(0, 0, 457, 355);


        jPanel = new JPanel();
        jPanel.setBackground(Color.WHITE);
        jButton1 = new JButton();
        jButton1.setBounds(141, 230, 71, 23);
        jButton2 = new JButton();
        jButton2.setBounds(222, 230, 94, 23);
        jLabel1 = new JLabel();
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setBounds(141, 49, 161, 24);
        jLabel2 = new JLabel();
        jLabel2.setBounds(88, 102, 43, 26);
        jLabel3 = new JLabel();
        jLabel3.setBounds(88, 140, 43, 26);
        jLabel4 = new JLabel();
        jLabel4.setBounds(234, 181, 80, 26);
        jTextField = new JTextField();
        jTextField.setBounds(141, 102, 175, 26);
        jTextField1 = new JTextField();
        jTextField1.setBounds(141, 181, 80, 26);
        //jTextField1.setText("请输入");
        jPanel.add(jTextField1);


        Object[] obj = VeriCodeUtil.createImage();
        veriCode = obj[0].toString();
        System.out.println("验证码:" + veriCode);
        ImageIcon img = new ImageIcon((BufferedImage) obj[1]);//创建图片对象
        jLabel4.setIcon((Icon)img);
        jPanel.add(jLabel4);

        jLabel4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 1){
                    //重新获取验证码
                    refreshPicture(jLabel4, jPanel);
                }

            }
        });



        //设置关闭方式
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        // 固定大小
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int var = JOptionPane.showConfirmDialog(LoginWindow.this, "确定离开吗?", "请确认", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (var == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        jButton1.setText("确认");
        // 添加登陆事件 ，登录判断用户名和密码
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (null == jTextField.getText() || "".equals(jTextField.getText())||
                        null == new String(jPasswordField.getPassword()) || "".equals(new String(jPasswordField.getPassword()))) {
                    JOptionPane.showMessageDialog(LoginWindow.this, "请输入用户名和密码");
                }else {
                    int uid = Integer.parseInt(jTextField.getText());
                    String passwordInfo = MD5Util.md5(new String(jPasswordField.getPassword()));

                    User user = userService.selById(uid);
                    //System.out.println(user.getUsername());
                    String password = null;
                    String username = null;
                    if(user != null){
                        password = user.getPassword();
                        username = user.getUsername();
                    }
                    //System.out.println(MD5Util.md5(passwordInfo).equals(password));

                    if(veriCode.equals(jTextField1.getText().trim())){

                        if (passwordInfo.equals(password)) {
                            setVisible(false);
                            int status = user.getStatus();
                            System.out.println("登录成功！！！: "+status);
                            if (status == 1) {

                                JOptionPane.showMessageDialog(LoginWindow.this, "欢迎您 "+ username);
                                new TeacherWindow();
                            } else {
                                //String name = userService.selById(uid).getUsername();
                                JOptionPane.showMessageDialog(LoginWindow.this, "欢迎您 "+ username);

                                new SelectCourseWindow(uid);

                            }
                        } else
                            JOptionPane.showMessageDialog(LoginWindow.this, "用户名或密码错误");

                    }else{
                        JOptionPane.showMessageDialog(LoginWindow.this, "验证码错误");
                    }




                }


            }
        });

        jButton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new ChangePasswordWindow();
            }
        });
        // 清空密码和用户名
        jButton2.setText("修改密码");//修改密码
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField.setText("");
            }
        });
        jLabel1.setFont(new Font("微软雅黑", 0, 18));
        //jLabel1.setText("登陆界面");//登陆界面

            jPasswordField = new JPasswordField();
            jPasswordField.setBounds(141, 141, 175, 26);




        jLabel2.setText("编号");

        jLabel3.setText("密码");



        jTextField.setFont(new Font("Dotum", 0, 14));


        jTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int keyChar = e.getKeyChar();
                if (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {
                } else {
                    e.consume();
                }
            }
        });


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setVerticalGroup(layout.createSequentialGroup().addComponent(jPanel, 0, 317, Short.MAX_VALUE));
        layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(jPanel, 0, 441, Short.MAX_VALUE));
        jPanel.setLayout(null);
        jPanel.add(jLabel3);
        jPanel.add(jLabel2);
        jPanel.add(jPasswordField);
        jPanel.add(jTextField);
        jPanel.add(jLabel1);
        jPanel.add(jButton1);
        jPanel.add(jButton2);
        jPanel.add(jlabel);

        pack();
        this.setSize(457, 355);
        // 置中
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


//    // 得到输入量 匹配用户名和密码
//
//    public static String getNameAndPassword(String str, String str1)
//            throws IOException {
//
//        InputStreamReader is = new InputStreamReader(new FileInputStream(new File("user.txt")));
//        BufferedReader br = new BufferedReader(is);
//        String line;
//        while (null != (line = br.readLine())) {
//            String[] np = line.split(":");
//            if (str.equals(np[0]) && str1.equals(np[2])) {
//                return np[1];
//            }
//        }
//        is.close();
//        return null;
//    }

    //添加图片，获取验证码
    public void refreshPicture(JLabel jlabel,JPanel jpanel){
        Object[] obj = VeriCodeUtil.createImage();
        String code = obj[0].toString();
        System.out.println("刷新后的验证码:" + code);
        ImageIcon img = new ImageIcon((BufferedImage)obj[1]);//创建图片对象
        jlabel.setIcon((Icon)img);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginWindow().setVisible(true);
            }
        });
    }

}