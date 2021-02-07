package com.yyh.view;

import com.yyh.pojo.Paper;
import com.yyh.pojo.Title;
import com.yyh.pojo.User;
import com.yyh.service.PaperService;
import com.yyh.service.TitleService;
import com.yyh.service.UserService;
import com.yyh.service.impl.PaperServiceImpl;
import com.yyh.service.impl.TitleServiceImpl;
import com.yyh.service.impl.UerServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: com.yyh.view
 * @version: 1.0
 */
public class ExamWindow extends JFrame {

    private JPanel jPanel1;
    private JButton jButton1;
    private Checkbox jCheckBox2;
    private JLabel jLabel3;
    private JButton jButton5;
    private JScrollPane jScrollPane1;
    private static JTextArea jTextArea1;
    private Checkbox jCheckBox4;
    private JLabel jLabel2;
    private Checkbox jCheckBox3;
    private Checkbox jCheckBox1;
    private JButton jButton3;
    private JButton jButton2;
    private JLabel jLabel1;
    private static CheckboxGroup checkboxGroup = new CheckboxGroup();


    // 判断时间是不是完成
    boolean flag = true;
    // 用户id
    int uid;
    // 用户名字
    String username;
    // 记录答题进度
    static int tltleNum = 1;

    // 存放分数
    int userPoint = 0;
    // 时间
    long time;
    // 存放User
    List<User> listUser;
    // 存放Title
    String[] strTitle;
    // 存放用户答案
    Map<Integer, String> mapAnswer = new HashMap<Integer, String>();

    // 注入TitleManage
    private static TitleService titleService = new TitleServiceImpl();
    // 注入UserManage
    private UserService userService = new UerServiceImpl();
    // 注入PaperManage
    private PaperService paperService = new PaperServiceImpl();

    Thread th = new Thread(
            new Runnable() {
                @Override
                public void run() {

                    try {
                        Paper temp = new Paper();
                        temp.setPid(uid);
                        temp.setCourse(SelectCourseWindow.SelectedCourse);
                        flag = timeDown(paperService.selByIdCou(temp).getTime());
                        if (flag == false) {
                            mapAnswer.put(tltleNum, checkboxGroup.getSelectedCheckbox().getLabel());
                            for (int i = 1; i <= mapAnswer.size(); i++) {
                                //保存最后一题答案
                                int tid2 = Integer.parseInt(strTitle[i - 1]);
                                // 取题目
                                Title tit = titleService.selById(tid2);
                                String key = tit.getTkey();
                                if (key.equals(mapAnswer.get(i))) {
                                    userPoint = userPoint + tit.getScore();
                                }
                            }
                            JOptionPane.showMessageDialog(ExamWindow.this, "时间到  " + username + "你的得分是：" + userPoint);

                            // 设置除开始按钮外，所有按钮为不可用
                            jButton2.setEnabled(false);
                            jButton3.setEnabled(false);
                            jButton5.setEnabled(false);
                        }
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                }
            }
    );


    public List<User> getList() {
        return listUser;
    }

    public void setList(List<User> listUser) {
        this.listUser = listUser;
    }

    public ExamWindow(int uid, String course) {

        setTitle("考试");//考试
        setIconImage(new ImageIcon("images/app.png").getImage());
        this.uid = uid;


        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        // 固定大小
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int var = JOptionPane.showConfirmDialog(ExamWindow.this, "确定离开吗?", "请确认", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (var == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });


        try {
            pack();
            this.setSize(812, 499);
        } catch (Exception e) {
            // add your error handling code here
            e.printStackTrace();
        }
        // 设置居中和可见
        setLocationRelativeTo(null);
        setVisible(true);
        // 固定大小
        setResizable(false);

        jPanel1 = new JPanel();
        jPanel1.setLayout(null);
        jPanel1.setPreferredSize(new Dimension(716, 455));
        jPanel1.add(getJScrollPane1());

        jLabel1 = new JLabel();
        jPanel1.add(jLabel1);
        jLabel1.setBounds(77, 7, 420, 35);
        jLabel1.setFont(new Font("楷体", 0, 20));


        jButton1 = new JButton();
        jPanel1.add(jButton1);
        jButton1.setText("开始做题");
        jButton1.setBounds(140, 399, 99, 23);


        jButton2 = new JButton();
        jPanel1.add(jButton2);
        jButton2.setText("下一题");
        jButton2.setBounds(472, 399, 81, 23);


        jButton3 = new JButton();
        jPanel1.add(jButton3);
        jButton3.setText("提交");
        jButton3.setBounds(622, 399, 81, 23);


        jCheckBox1 = new Checkbox("A", checkboxGroup, true);
        jPanel1.add(jCheckBox1);
        // jCheckBox1.setText("A");
        jCheckBox1.setBounds(326, 357, 36, 27);


        jCheckBox2 = new Checkbox("B", checkboxGroup, false);
        jPanel1.add(jCheckBox2);
        // jCheckBox2.setText("B");
        jCheckBox2.setBounds(386, 360, 42, 21);


        jCheckBox3 = new Checkbox("C", checkboxGroup, false);
        jPanel1.add(jCheckBox3);
        // jCheckBox3.setText("C");
        jCheckBox3.setBounds(456, 361, 33, 19);


        jLabel2 = new JLabel();
        jPanel1.add(jLabel2);
        jPanel1.add(getJCheckBox4());
        jPanel1.add(getJButton5());
        jPanel1.add(getJLabel3());
        jLabel2.setText("选择");
        jLabel2.setBounds(264, 362, 41, 17);

        //先把上一题、下一题、提交禁掉
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton5.setEnabled(false);


        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        getContentPane().setLayout(groupLayout);

        // 开始做题事件
        jButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Paper papertemp = new Paper();
                papertemp.setPid(uid);
                papertemp.setCourse(SelectCourseWindow.SelectedCourse.trim());
                Paper isexam = paperService.isExam(papertemp);
                System.out.println("---------------");
                System.out.println(isexam);
                System.out.println("---------------");
                if(isexam.getUserPoint() != -1){
                    JOptionPane.showMessageDialog(ExamWindow.this, userService.selById(uid).getUsername()+" 你已经考完"+isexam.getCourse()+",得分为："+isexam.getUserPoint());
                    System.exit(0);
                }

                username = userService.selById(uid).getUsername();
                time = System.currentTimeMillis();


                Paper temp = new Paper();
                temp.setPid(uid);
                temp.setCourse(course);
                Paper paper = paperService.selByIdCou(temp);
                strTitle = paper.getListTitle().split(",");
                // 题号
                int tid1 = Integer.parseInt(strTitle[0]);

                showTitle(tid1);

                jButton1.setEnabled(false);
                jButton5.setEnabled(false);
                jButton2.setEnabled(true);
                jButton3.setEnabled(true);
                th.start();
            }
        });
        // 下一题
        jButton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // 题号
                int tid1 = Integer.parseInt(strTitle[tltleNum]);
                // 保存用户答案
                mapAnswer
                        .put(tltleNum, checkboxGroup.getSelectedCheckbox().getLabel());
                tltleNum++;//paperService.selById(uid).getCourse()
                jLabel1.setText("课程：" + SelectCourseWindow.SelectedCourse
                        + ";" + username + "你的答题进度为" + tltleNum + "/"
                        + strTitle.length);

                checkboxGroup.getSelectedCheckbox();

                showTitle(tid1);

                if ("A".equals(mapAnswer.get(tltleNum))) {
                    jCheckBox1.setState(true);
                }

                if ("B".equals(mapAnswer.get(tltleNum))) {
                    jCheckBox2.setState(true);
                }

                if ("C".equals(mapAnswer.get(tltleNum))) {
                    jCheckBox3.setState(true);
                }

                if ("D".equals(mapAnswer.get(tltleNum))) {
                    jCheckBox4.setState(true);
                }

                jButton5.setEnabled(true);
                if (tltleNum == strTitle.length) {
                    jButton2.setEnabled(false);
                }

            }
        });
        // 上一题的事件
        jButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 保存用户答案
                mapAnswer
                        .put(tltleNum, checkboxGroup.getSelectedCheckbox().getLabel());
                // 题号

                tltleNum--;

                jLabel1.setText("课程：" + SelectCourseWindow.SelectedCourse
                        + ";" + username + "你的答题进度为" + tltleNum + "/"
                        + strTitle.length);

                int tid1 = Integer.parseInt(strTitle[tltleNum]);
                // 取到学生的答案，设置对应选项为 选择状态
                if ("A".equals(mapAnswer.get(tltleNum))) {
                    jCheckBox1.setState(true);
                }

                if ("B".equals(mapAnswer.get(tltleNum))) {
                    jCheckBox2.setState(true);
                }

                if ("C".equals(mapAnswer.get(tltleNum))) {
                    jCheckBox3.setState(true);
                }

                if ("D".equals(mapAnswer.get(tltleNum))) {
                    jCheckBox4.setState(true);
                }

                // System.out.println(i);
                // 题目序列为1的时候，上一题按钮屏蔽，否则 可用
                if (tltleNum == 1) {
                    jButton5.setEnabled(false);
                } else {
                    jButton5.setEnabled(true);
                }
                if (tltleNum != strTitle.length) {
                    jButton2.setEnabled(true);
                }
                // 显示题目
                showTitle(tid1);

            }
        });

        // 提交事件 完成答案的提交，给出分数
        jButton3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //保存最后一题答案
                mapAnswer.put(tltleNum, checkboxGroup.getSelectedCheckbox().getLabel());
                for (int i = 1; i <= mapAnswer.size(); i++) {

                    int tid2 = Integer.parseInt(strTitle[i - 1]);
                    // 取题目
                    Title tit = titleService.selById(tid2);

                    String key = tit.getTkey();
                    if (key.equals(mapAnswer.get(i))) {
                        userPoint = userPoint + tit.getScore();
                    }
                }
                JOptionPane.showMessageDialog(ExamWindow.this, username + "你的得分是：" + userPoint);

                jLabel1.setText(username + "恭喜你答题完成;" + "得分为：" + userPoint);

                //提交分数
                System.out.println(uid + " "+SelectCourseWindow.SelectedCourse.trim()+" "+userPoint);
                paperService.updIdCourse(uid, SelectCourseWindow.SelectedCourse.trim(), userPoint);

                // 设置 除提交按钮外 所有按钮为不可用
                jButton2.setEnabled(false);
                jButton3.setEnabled(false);
                jButton5.setEnabled(false);

                flag = false;
                th.stop();
                jLabel3.setText("考试结束");
            }
        });


    }


    private JTextArea getJTextArea1() {
        if (jTextArea1 == null) {
            jTextArea1 = new JTextArea();
            jTextArea1.setBounds(68, 50, 660, 285);
            jTextArea1.setFont(new Font("仿宋",1,19));
            jTextArea1.setEnabled(false);
        }
        return jTextArea1;
    }

    private JScrollPane getJScrollPane1() {
        if (jScrollPane1 == null) {
            jScrollPane1 = new JScrollPane();
            jScrollPane1.setBounds(68, 50, 660, 285);
            jScrollPane1.setViewportView(getJTextArea1());
        }
        return jScrollPane1;
    }

    private Checkbox getJCheckBox4() {
        if (jCheckBox4 == null) {
            jCheckBox4 = new Checkbox("D", checkboxGroup, false);
            // jCheckBox4.setText("D");
            jCheckBox4.setBounds(516, 359, 44, 22);

        }
        return jCheckBox4;
    }

    private JButton getJButton5() {
        if (jButton5 == null) {
            jButton5 = new JButton();
            jButton5.setText("上一题");//上一题
            jButton5.setBounds(311, 399, 81, 23);

        }
        return jButton5;
    }

    // 显示题目状态
    public static void showTitle(int tid) {
        Title tit = titleService.selById(tid);
        String question = tit.getQuestion();
        String option = tit.getToption();
        StringBuffer sb = new StringBuffer();
        int level = tit.getLevel();
        // System.out.println(option);
        String option1[] = option.split(",");
        sb.append("第" + tltleNum + "题" + "：  " + question + "(等级为：" + level + ")"
                + "\n");
        sb.append(option1[0] + " " + "\n");
        sb.append(option1[1] + "\n");
        sb.append(option1[2] + "\n");
        sb.append(option1[3] + "\n");
        jTextArea1.setText(sb.toString());

        //

    }

    private JLabel getJLabel3() {
        if (jLabel3 == null) {
            jLabel3 = new JLabel();
            jLabel3.setBounds(553, 7, 168, 35);
            jLabel3.setFont(new java.awt.Font("微软雅黑", 1, 16));
        }
        return jLabel3;
    }

    public boolean timeDown(int time) throws InterruptedException {
        for (int j = 1; j <= time; j++) {

            for (int i = 0; i <= 59; i++) {
                new Thread().sleep(1000);
                int sec = 59 - i;
                if (sec < 10) {

                    jLabel3.setText("考试剩余时间：" + (time - j) + ":" + ("0" + sec));
                } else
                    jLabel3.setText("考试剩余时间：" + (time - j) + ":" + (sec));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new ExamWindow(1028,"离散数学");
    }

}
