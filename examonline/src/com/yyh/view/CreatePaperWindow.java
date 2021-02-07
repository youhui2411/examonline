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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Description: com.yyh.view
 * @version: 1.0
 */
public class CreatePaperWindow extends JFrame {

    private JPanel jPanel1;
    private JLabel jLabel3;
    private JButton jButton1;
    private JButton jButton2;
    private JComboBox jComboBox2;
    private JLabel jLabel2;
    private JComboBox jComboBox1;
    private JLabel jLabel1;

    // 注入TitleService
    private TitleService titleService = new TitleServiceImpl();
    // 注入UserService
    private UserService userService = new UerServiceImpl();
    // 注入PaperService
    private PaperService paperService = new PaperServiceImpl();


    public CreatePaperWindow() {

        setTitle("试卷管理");//试卷管理

        setIconImage(new ImageIcon("images/app.png").getImage());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1 = new JPanel();
        getContentPane().add(jPanel1, BorderLayout.CENTER);

        jPanel1.setPreferredSize(new java.awt.Dimension(477, 334));

        jLabel1 = new JLabel();
        jLabel1.setBounds(73, 92, 67, 26);
        jLabel1.setText("考试课程");//考试课程


        jLabel3 = new JLabel();
        jLabel3.setBounds(73, 157, 67, 26);
        jLabel3.setText("考试时间");//考试时间


        jButton1 = new JButton();
        jButton1.setBounds(155, 230, 115, 26);
        jButton1.setText("随机产生试卷");//随机产生试卷


        ComboBoxModel jComboBox1Model = new DefaultComboBoxModel(new Integer[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120});
        jComboBox1 = new JComboBox();
        jComboBox1.setBounds(157, 157, 229, 26);
        jComboBox1.setModel(jComboBox1Model);


        jLabel2 = new JLabel();
        jLabel2.setBounds(395, 157, 48, 26);
        jLabel2.setText("分钟");//分钟


        ComboBoxModel jComboBox2Model = new DefaultComboBoxModel(
                new String[]{"离散数学", "操作系统", "编译原理"});
        jComboBox2 = new JComboBox();
        jComboBox2.setBounds(157, 92, 229, 26);
        jComboBox2.setModel(jComboBox2Model);


        jButton2 = new JButton();
        jButton2.setBounds(280, 230, 106, 26);
        jButton2.setText("删除试卷");//删除试卷


        jPanel1.setLayout(null);
        jPanel1.add(jLabel1);
        jPanel1.add(jLabel3);
        jPanel1.add(jButton1);
        jPanel1.add(jComboBox1);
        jPanel1.add(jLabel2);
        jPanel1.add(jComboBox2);
        jPanel1.add(jButton2);

        pack();
        this.setSize(494, 381);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);


        //组试卷
        jButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String course = ((String) jComboBox2.getSelectedItem()).trim();
                List<String> list = paperService.selCourse();
                for(int i = 0; i < list.size(); i++){
                    if(course.equals(list.get(i))){
                        JOptionPane.showMessageDialog(CreatePaperWindow.this, "不能重复出卷哦！");
                        return;
                    }
                }
                int questionNum = 50;
                //List<Title> listTitles = titleService.selByCourse(course);
                int time = (Integer) jComboBox1.getSelectedItem();
                int point = 100;

                List<User> listUser = userService.selAll();

                String[] result = getListTitle(course);

                for (int i = 1; i < listUser.size(); i++) {


                    User user = listUser.get(i);

                    Paper paper = new Paper();
                    paper.setPid(user.getUid());
                    paper.setCourse(course);
                    paper.setQuestionNum(questionNum);
                    paper.setTime(time);
                    paper.setPoint(point);
                    paper.setListTitle(result[0]);
                    paper.setListAnswer(result[1]);
                    paper.setUserPoint(-1);

                    if (paperService.selByIdCourse(paper) == true) {
                        paperService.upd(paper);
                    } else {
                        paperService.ins(paper);
                    }

                    // 用户的试卷编号即为用户编号
                    user.setPaperId(paper.getPid());
                    userService.upd(user);

                }
                JOptionPane.showMessageDialog(CreatePaperWindow.this, "create paper success!!!");

            }

        });

        //删除试卷
        jButton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String course = ((String) jComboBox2.getSelectedItem()).trim();


                List<Paper> list = paperService.selByCourse(course);
                for (int i = 0; i < list.size(); i++) {
                    paperService.del(list.get(i));
                }
            }
        });


    }

    // 用来得到试卷的题目列表

    public String[] getListTitle(String course) {

        String listTitle = "";
        String listAnswer = "";
        // 用来存放10个等级的题目序列 1,2,3,4,5,6,7,8,9,10
        String level1 = "";
        String level2 = "";
        String level3 = "";
        String level4 = "";
        String level5 = "";
        String level6 = "";
        String level7 = "";
        String level8 = "";
        String level9 = "";
        String level10 = "";

        List<Title> list1 = titleService.selByCourseLevel(course, 1);
        int[] title1 = new int[list1.size()];
        for (int i = 0; i < title1.length; i++) {
            title1[i] = i;
        }
        List<Title> list2 = titleService.selByCourseLevel(course, 2);
        int[] title2 = new int[list2.size()];
        for (int i = 0; i < title2.length; i++) {
            title2[i] = i;
        }
        List<Title> list3 = titleService.selByCourseLevel(course, 3);
        int[] title3 = new int[list3.size()];
        for (int i = 0; i < title3.length; i++) {
            title3[i] = i;
        }
        List<Title> list4 = titleService.selByCourseLevel(course, 4);
        int[] title4 = new int[list4.size()];
        for (int i = 0; i < title4.length; i++) {
            title4[i] = i;
        }
        List<Title> list5 = titleService.selByCourseLevel(course, 5);
        int[] title5 = new int[list5.size()];
        for (int i = 0; i < title5.length; i++) {
            title5[i] = i;
        }
        List<Title> list6 = titleService.selByCourseLevel(course, 6);
        int[] title6 = new int[list6.size()];
        for (int i = 0; i < title6.length; i++) {
            title6[i] = i;
        }
        List<Title> list7 = titleService.selByCourseLevel(course, 7);
        int[] title7 = new int[list7.size()];
        for (int i = 0; i < title7.length; i++) {
            title7[i] = i;
        }
        List<Title> list8 = titleService.selByCourseLevel(course, 8);
        int[] title8 = new int[list8.size()];
        for (int i = 0; i < title8.length; i++) {
            title8[i] = i;
        }
        List<Title> list9 = titleService.selByCourseLevel(course, 9);
        int[] title9 = new int[list9.size()];
        for (int i = 0; i < title9.length; i++) {
            title9[i] = i;
        }
        List<Title> list10 = titleService.selByCourseLevel(course, 10);
        int[] title10 = new int[list10.size()];
        for (int i = 0; i < title10.length; i++) {
            title10[i] = i;
        }

        int[] r = new int[5];
        rndInt(5, title1, r);

        String listAnswer1 = "";
        for (int i = 0; i < 5; i++) {

            if (i != 4) {
                listAnswer1 += list1.get(r[i]).getTkey() + ",";
            } else {
                listAnswer1 += list1.get(r[i]).getTkey();
            }
        }
        for (int i = 0; i < 5; i++) {
            if (i != 4) {
                level1 += list1.get(r[i]).getTid() + ",";
            } else {
                level1 += list1.get(r[i]).getTid();
            }
        }

        rndInt(5, title2, r);
        String listAnswer2 = "";
        for (int i = 0; i < 5; i++) {

            if (i != 4) {
                listAnswer2 += list2.get(r[i]).getTkey() + ",";
            } else {
                listAnswer2 += list2.get(r[i]).getTkey();
            }
        }
        for (int i = 0; i < 5; i++) {
            if (i != 4) {
                level2 += list2.get(r[i]).getTid() + ",";
            } else {
                level2 += list2.get(r[i]).getTid();
            }
        }

        rndInt(5, title3, r);
        String listAnswer3 = "";
        for (int i = 0; i < 5; i++) {

            if (i != 4) {
                listAnswer3 += list3.get(r[i]).getTkey() + ",";
            } else {
                listAnswer3 += list3.get(r[i]).getTkey();
            }
        }
        for (int i = 0; i < 5; i++) {
            if (i != 4) {
                level3 += list3.get(r[i]).getTid() + ",";
            } else {
                level3 += list3.get(r[i]).getTid();
            }
        }

        rndInt(5, title4, r);
        String listAnswer4 = "";
        for (int i = 0; i < 5; i++) {

            if (i != 4) {
                listAnswer4 += list4.get(r[i]).getTkey() + ",";
            } else {
                listAnswer4 += list4.get(r[i]).getTkey();
            }
        }
        for (int i = 0; i < 5; i++) {
            if (i != 4) {
                level4 += list4.get(r[i]).getTid() + ",";
            } else {
                level4 += list4.get(r[i]).getTid();
            }
        }
        rndInt(5, title5, r);
        String listAnswer5 = "";
        for (int i = 0; i < 5; i++) {

            if (i != 4) {
                listAnswer5 += list5.get(r[i]).getTkey() + ",";
            } else {
                listAnswer5 += list5.get(r[i]).getTkey();
            }
        }
        for (int i = 0; i < 5; i++) {
            if (i != 4) {
                level5 += list5.get(r[i]).getTid() + ",";
            } else {
                level5 += list5.get(r[i]).getTid();
            }
        }
        rndInt(5, title6, r);
        String listAnswer6 = "";
        for (int i = 0; i < 5; i++) {

            if (i != 4) {
                listAnswer6 += list6.get(r[i]).getTkey() + ",";
            } else {
                listAnswer6 += list6.get(r[i]).getTkey();
            }
        }
        for (int i = 0; i < 5; i++) {
            if (i != 4) {
                level6 += list6.get(r[i]).getTid() + ",";
            } else {
                level6 += list6.get(r[i]).getTid();
            }
        }
        rndInt(5, title7, r);
        String listAnswer7 = "";
        for (int i = 0; i < 5; i++) {
            if (i != 4) {
                listAnswer7 += list7.get(r[i]).getTkey() + ",";
            } else {
                listAnswer7 += list7.get(r[i]).getTkey();
            }
        }
        for (int i = 0; i < 5; i++) {
            if (i != 4) {
                level7 += list7.get(r[i]).getTid() + ",";
            } else {
                level7 += list7.get(r[i]).getTid();
            }
        }
        rndInt(5, title8, r);
        String listAnswer8 = "";
        for (int i = 0; i < 5; i++) {
            if (i != 4) {
                listAnswer8 += list8.get(r[i]).getTkey() + ",";
            } else {
                listAnswer8 += list8.get(r[i]).getTkey();
            }
        }
        for (int i = 0; i < 5; i++) {
            if (i != 4) {
                level8 += list8.get(r[i]).getTid() + ",";
            } else {
                level8 += list8.get(r[i]).getTid();
            }
        }
        rndInt(5, title9, r);
        String listAnswer9 = "";
        for (int i = 0; i < 5; i++) {
            if (i != 4) {
                listAnswer9 += list9.get(r[i]).getTkey() + ",";
            } else {
                listAnswer9 += list9.get(r[i]).getTkey();
            }
        }
        for (int i = 0; i < 5; i++) {
            if (i != 4) {
                level9 += list9.get(r[i]).getTid() + ",";
            } else {
                level9 += list9.get(r[i]).getTid();
            }
        }
        rndInt(5, title10, r);
        String listAnswer10 = "";
        for (int i = 0; i < 5; i++) {
            if (i != 4) {
                listAnswer10 += list10.get(r[i]).getTkey() + ",";
            } else {
                listAnswer10 += list10.get(r[i]).getTkey();
            }
        }
        for (int i = 0; i < 5; i++) {
            if (i != 4) {
                level10 += list10.get(r[i]).getTid() + ",";
            } else {
                level10 += list10.get(r[i]).getTid();
            }
        }


        listTitle += level1 + ",";
        listTitle += level2 + ",";
        listTitle += level3 + ",";
        listTitle += level4 + ",";
        listTitle += level5 + ",";
        listTitle += level6 + ",";
        listTitle += level7 + ",";
        listTitle += level8 + ",";
        listTitle += level9 + ",";
        listTitle += level10;

        listAnswer += listAnswer1 + ",";
        listAnswer += listAnswer2 + ",";
        listAnswer += listAnswer3 + ",";
        listAnswer += listAnswer4 + ",";
        listAnswer += listAnswer5 + ",";
        listAnswer += listAnswer6 + ",";
        listAnswer += listAnswer7 + ",";
        listAnswer += listAnswer8 + ",";
        listAnswer += listAnswer9 + ",";
        listAnswer += listAnswer10;


        String[] result = new String[2];
        result[0] = listTitle;
        result[1] = listAnswer;
        return result;
    }

    public void rndInt(int count, int[] title, int[] r) {
        Random rnd = new Random();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < title.length; i++) {
            list.add(title[i]);
        }
        for (int i = 0; i < count; i++) {
            int tempidx = (int) Math.floor(rnd.nextDouble() * list.size());
            r[i] = list.get(tempidx);
            list.remove(tempidx);
        }
    }

}



