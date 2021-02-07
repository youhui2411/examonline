package com.yyh.view;

import com.yyh.pojo.Title;
import com.yyh.service.TitleService;
import com.yyh.service.impl.TitleServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description: com.yyh.view
 * @version: 1.0
 */
public class UpdateTitleWindow extends JFrame{

    private JButton jButton1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JComboBox jComboBox1;
    private JComboBox jComboBox5;
    private JComboBox jComboBox4;
    private JComboBox jComboBox3;
    private JLabel jLabel1;
    private JTextArea jTextArea1;
    private JTextField jTextField2;
    private JButton jButton2;
    private JLabel jLabel10;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JPanel jPanel1;
    private Title title;

    private TitleService titleService = new TitleServiceImpl();

    public UpdateTitleWindow(Title title) {
        this.title = title;


        setIconImage(new ImageIcon("images/app.png").getImage());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

            jPanel1 = new JPanel();
            getContentPane().add(jPanel1);
            jPanel1.setBounds(0, 0, 605, 392);
            jPanel1.setLayout(null);

                jLabel7 = new JLabel();
                jPanel1.add(jLabel7);
                jLabel7.setText("题目选项");//题目选项
                jLabel7.setBounds(63, 175, 70, 14);


                jButton1 = new JButton();
                jPanel1.add(jButton1);
                jButton1.setText("修改");//修改
                jButton1.setBounds(223, 341, 67, 24);


                jButton2 = new JButton();
                jPanel1.add(jButton2);
                jButton2.setText("清空");//清空
                jButton2.setBounds(339, 341, 68, 24);


                jLabel8 = new JLabel();
                jPanel1.add(jLabel8);
                jLabel8.setText("题目答案");//题目答案
                jLabel8.setBounds(63, 217, 70, 14);


                jLabel10 = new JLabel();
                jPanel1.add(jLabel10);
                jLabel10.setText("题目难度");//题目难度
                jLabel10.setBounds(63, 259, 70, 14);
                jLabel10.setOpaque(true);


                jLabel2 = new JLabel();
                jPanel1.add(jLabel2);
                jLabel2.setText("题目内容  ");//题目内容
                jLabel2.setBounds(60, 45, 91, 33);
                jLabel2.setOpaque(true);


                jTextField2 = new JTextField();
                jPanel1.add(jTextField2);
                jTextField2.setText(title.getToption());
                jTextField2.setBounds(168, 166, 329, 30);


                jTextArea1 = new JTextArea();
                jPanel1.add(jTextArea1);
                jTextArea1.setText(title.getQuestion());
                jTextArea1.setBounds(169, 23, 327, 72);


                jLabel1 = new JLabel();
                jPanel1.add(jLabel1);
                jLabel1.setText("题目分数");//题目分数
                jLabel1.setOpaque(true);
                jLabel1.setBounds(63, 294, 70, 14);



                ComboBoxModel jComboBox3Model = new DefaultComboBoxModel(
                        new String[] { "A", "B", "C", "D" });
                jComboBox3 = new JComboBox();
                jPanel1.add(jComboBox3);
                System.out.println(title.getTkey());
                jComboBox3.setSelectedItem(title.getTkey());
                jComboBox3.setModel(jComboBox3Model);
                jComboBox3.setBounds(168, 217, 98, 21);


                ComboBoxModel jComboBox4Model = new DefaultComboBoxModel(
                        new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
                jComboBox4 = new JComboBox();
                jPanel1.add(jComboBox4);
                jComboBox4.setModel(jComboBox4Model);
                jComboBox4.setBounds(168, 259, 98, 21);


                ComboBoxModel jComboBox5Model = new DefaultComboBoxModel(
                        new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
                                12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
                                23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33,
                                34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44,
                                45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55,
                                56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66,
                                67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77,
                                78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88,
                                89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99,
                                100 });
                jComboBox5 = new JComboBox();
                jPanel1.add(jComboBox5);
                jComboBox5.setModel(jComboBox5Model);
                jComboBox5.setBounds(168, 294, 98, 21);


                jLabel3 = new JLabel();
                jPanel1.add(jLabel3);
                jLabel3.setText("所属课程");//所属课程
                jLabel3.setBounds(63, 126, 70, 14);


                ComboBoxModel jComboBox1Model =
                        new DefaultComboBoxModel(
                                new String[] {"JAVA SE", "MySql", "离散数学", "操作系统",
                                        "计算机网络", "编译原理", "C语言", "C++", "汇编语言" });
                jComboBox1 = new JComboBox();
                jPanel1.add(jComboBox1);
                jComboBox1.setModel(jComboBox1Model);
                jComboBox1.setBounds(168, 119, 98, 21);


        pack();
        this.setSize(621, 430);

        setLocationRelativeTo(null);
        setVisible(true);

        // 修改密码事件
        jButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int tid = title.getTid();
                String question = jTextArea1.getText();
                String option = jTextField2.getText();
                String key = (String) jComboBox3.getSelectedItem();
                String course = (String) jComboBox1.getSelectedItem();
                int level = (Integer) jComboBox4.getSelectedItem();
                int score = (Integer) jComboBox5.getSelectedItem();
                Title title1 = new Title();
                title1.setTid(tid);
                title1.setQuestion(question);
                title1.setToption(option);
                title1.setTkey(key);
                title1.setLevel(level);
                title1.setScore(score);
                title1.setCourse(course);

                titleService.upd(title1);
                JOptionPane
                        .showMessageDialog(UpdateTitleWindow.this, "update success!!!");
            }
        });


    }
}
