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
public class AddTitleWindow extends JFrame{
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel12;
    private JComboBox jComboBox3;
    private JComboBox jComboBox2;
    private JComboBox jComboBox1;
    private JTextField jTextField3;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JTextArea jTextArea1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField4;
    private JComboBox jComboBox4;

    private TitleService titleService = new TitleServiceImpl();

    public JTextField getJTextField2() {
        return jTextField2;
    }

    public AddTitleWindow() {

        try {
            setIconImage(new ImageIcon("images/app.png").getImage());
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                jPanel1 = new JPanel();
                jPanel1.setLayout(null);

                    jLabel1 = new JLabel();
                    jPanel1.add(jLabel1);
                    jLabel1.setText("题目内容");//题目内容
                    jLabel1.setBounds(67, 48, 91, 33);


                    jTextArea1 = new JTextArea();
                    jPanel1.add(jTextArea1);
                    jTextArea1.setBounds(176, 22, 391, 86);


                    jLabel2 = new JLabel();
                    jPanel1.add(jLabel2);
                    jLabel2.setText("A");
                    jLabel2.setBounds(176, 186, 26, 17);


                    jTextField1 = new JTextField();
                    jPanel1.add(jTextField1);
                    jTextField1.setBounds(222, 183, 131, 24);


                    jLabel3 = new JLabel();
                    jPanel1.add(jLabel3);
                    jLabel3.setText("B");
                    jLabel3.setBounds(392, 186, 26, 17);


                    jTextField2 = new JTextField();
                    jPanel1.add(getJTextField2());
                    jTextField2.setBounds(436, 183, 131, 24);


                    jLabel4 = new JLabel();
                    jPanel1.add(jLabel4);
                    jLabel4.setText("C");
                    jLabel4.setBounds(176, 219, 26, 16);


                    jLabel5 = new JLabel();
                    jPanel1.add(jLabel5);
                    jLabel5.setText("D");
                    jLabel5.setBounds(392, 219, 20, 17);


                    jLabel6 = new JLabel();
                    jPanel1.add(jLabel6);
                    jLabel6.setText("题目选项");//题目选项
                    jLabel6.setBounds(67, 186, 59, 17);


                    jLabel7 = new JLabel();
                    jPanel1.add(jLabel7);
                    jLabel7.setText("题目答案");//题目答案
                    jLabel7.setBounds(67, 266, 68, 17);


                    jButton1 = new JButton();
                    jPanel1.add(jButton1);
                    jButton1.setText("增加");//增加
                    jButton1.setBounds(176, 419, 67, 24);


                    jButton2 = new JButton();
                    jPanel1.add(jButton2);
                    jButton2.setText("清空");//清空
                    jButton2.setBounds(365, 419, 68, 24);


                    jTextField4 = new JTextField();
                    jPanel1.add(jTextField4);
                    jTextField4.setBounds(436, 217, 131, 21);


                    jLabel8 = new JLabel();
                    jPanel1.add(jLabel8);
                    jLabel8.setText("题目难度");//题目难度
                    jLabel8.setBounds(67, 323, 68, 17);


                    jLabel9 = new JLabel();
                    jPanel1.add(jLabel9);
                    jLabel9.setText("1---5之间");//之间
                    jLabel9.setBounds(275, 323, 137, 17);


                    jLabel10 = new JLabel();
                    jPanel1.add(jLabel10);
                    jLabel10.setText("题目分数");//题目分数
                    jLabel10.setBounds(67, 372, 68, 17);
                    jLabel10.setOpaque(true);


                    jLabel11 = new JLabel();
                    jPanel1.add(jLabel11);
                    jLabel11.setText("0---100之间");//之间
                    jLabel11.setBounds(275, 375, 137, 17);
                    jLabel11.setOpaque(true);


                    jTextField3 = new JTextField();
                    jPanel1.add(jTextField3);
                    jTextField3.setBounds(222, 216, 131, 24);


                    ComboBoxModel jComboBox1Model = new DefaultComboBoxModel(
                            new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
                    jComboBox1 = new JComboBox();
                    jPanel1.add(jComboBox1);
                    jComboBox1.setModel(jComboBox1Model);
                    jComboBox1.setBounds(176, 319, 73, 24);


                    ComboBoxModel jComboBox2Model = new DefaultComboBoxModel(
                            new String[] { "A", "B", "C", "D" });
                    jComboBox2 = new JComboBox();
                    jPanel1.add(jComboBox2);
                    jComboBox2.setModel(jComboBox2Model);
                    jComboBox2.setBounds(176, 262, 73, 24);



                    ComboBoxModel jComboBox3Model = new DefaultComboBoxModel(
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
                    jComboBox3 = new JComboBox();
                    jComboBox3.setMaximumRowCount(5);
                    jPanel1.add(jComboBox3);
                    jComboBox3.setModel(jComboBox3Model);
                    jComboBox3.setBounds(176, 368, 73, 24);


                    jLabel12 = new JLabel();
                    jPanel1.add(jLabel12);
                    jLabel12.setText("所属课程");//所属课程
                    jLabel12.setBounds(67, 138, 59, 17);


                    ComboBoxModel jComboBox4Model =
                            new DefaultComboBoxModel(
                                    new String[] {"JAVA SE", "MySql", "离散数学", "操作系统",
                                            "计算机网络", "编译原理", "C语言", "C++", "汇编语言"});
                    jComboBox4 = new JComboBox();
                    jPanel1.add(jComboBox4);
                    jComboBox4.setModel(jComboBox4Model);
                    jComboBox4.setBounds(176, 134, 107, 24);

            GroupLayout groupLayout = new GroupLayout(getContentPane());
            groupLayout.setHorizontalGroup(
                    groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 723, GroupLayout.PREFERRED_SIZE)
            );
            groupLayout.setVerticalGroup(
                    groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 488, GroupLayout.PREFERRED_SIZE)
            );
            getContentPane().setLayout(groupLayout);
            pack();
            this.setSize(734, 526);

            setLocationRelativeTo(null);
            setVisible(true);

            // 增加题目事件
            jButton1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    String question = jTextArea1.getText();
                    // System.out.println(question);
                    String option = "A:" + jTextField1.getText() + ",B:"
                            + jTextField2.getText() + ",C:"
                            + jTextField3.getText() + ",D:"
                            + jTextField4.getText();
                    String key = (String) jComboBox2.getSelectedItem();
                    int level = (Integer) (jComboBox1.getSelectedItem());
                    int score = (Integer) jComboBox3.getSelectedItem();
                    String course = (String) jComboBox4.getSelectedItem();
                    System.out.println(level);

                    Title title = new Title();
                    // title.setTid(1);
                    title.setQuestion(question);
                    title.setToption(option);
                    title.setTkey(key);
                    title.setLevel(level);
                    title.setScore(score);
                    title.setCourse(course);

                    titleService.ins(title);
                    JOptionPane.showMessageDialog(AddTitleWindow.this, "add success!!!");
                }
            });
        } catch (Exception e) {
            // add your error handling code here
            e.printStackTrace();
        }

        jButton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jTextArea1.setText("");
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                jComboBox1.setSelectedIndex(0);
                jComboBox2.setSelectedIndex(2);
                jComboBox3.setSelectedIndex(4);

            }
        });


    }
}
