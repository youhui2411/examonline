package com.yyh.view;

import com.yyh.exception.StudentExistException;
import com.yyh.pojo.Title;
import com.yyh.service.TitleService;
import com.yyh.service.impl.TitleServiceImpl;
import com.yyh.util.ImportTitleUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

/**
 * @Description: com.yyh.view
 * @version: 1.0
 */
public class TitleManageWindow extends JFrame {

    private JPanel jPanel1;
    private JButton jButton1;
    private JButton jButton4;
    private JScrollPane jScrollPane1;
    private JButton jButton5;
    private JButton jButton3;
    private JButton jButton2;
    private JTable jTable1;
    private String[][] listTitle;


    private static TitleService titleService = new TitleServiceImpl();

    public static String[][] titleList() {

        List<Title> titles = titleService.selAll();
        int size = titles.size();
        String titleStr[][] = new String[size][7];
        for (int i = 0; i < titles.size(); i++) {
            Title title = titles.get(i);
            titleStr[i][0] = title.getTid() + "";
            titleStr[i][1] = title.getCourse();
            titleStr[i][2] = title.getQuestion();
            titleStr[i][3] = title.getToption();
            titleStr[i][4] = title.getTkey();
            titleStr[i][5] = title.getLevel() + "";
            titleStr[i][6] = title.getScore() + "";
        }

        return titleStr;
    }

    public TitleManageWindow() {
        //设置一下主题
        try {
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("题目管理");//题目管理
        setResizable(false);

        setIconImage(new ImageIcon("images/app.png").getImage());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jPanel1 = new JPanel();
        getContentPane().add(jPanel1, BorderLayout.CENTER);

        jScrollPane1 = new JScrollPane();

        listTitle = titleList();
        TableModel jTable1Model = new DefaultTableModel(listTitle, new String[]{"题目编号", "所属课程", "题目内容", "题目选项", "题目答案", "题目等级", "题目分数"});
        jTable1 = new JTable();
        jScrollPane1.setViewportView(jTable1);
        jTable1.setModel(jTable1Model);
        jTable1.setBounds(7, 25, 685, 337);


        jButton1 = new JButton();
        jButton1.setText("删除");


        jButton2 = new JButton();
        jButton2.setText("手动增加");//手动增加


        jButton3 = new JButton();
        jButton3.setText("修改");


        jButton4 = new JButton();
        jButton4.setText("刷新");//刷新


        jButton5 = new JButton();
        jButton5.setText("批量导入");//批量导入


        GroupLayout gl_jPanel1 = new GroupLayout(jPanel1);
        gl_jPanel1.setHorizontalGroup(
                gl_jPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_jPanel1.createSequentialGroup()
                                .addGap(7)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 685, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_jPanel1.createSequentialGroup()
                                .addGap(54)
                                .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                .addGap(50)
                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                .addGap(63)
                                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                .addGap(63)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                .addGap(47)
                                .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
        );
        gl_jPanel1.setVerticalGroup(
                gl_jPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_jPanel1.createSequentialGroup()
                                .addGap(25)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
                                .addGap(29)
                                .addGroup(gl_jPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1.setLayout(gl_jPanel1);
        pack();
        this.setSize(715, 468);
        setLocationRelativeTo(null);
        setVisible(true);
        // 批量导入的事件
        jButton5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                ImportTitleUtil importTitleUtil = new ImportTitleUtil();
                try {
                    importTitleUtil.insertTitle(importTitleUtil.getTitles());

                    listTitle = titleList();
                    TableModel jTable1Model = new DefaultTableModel(listTitle, new String[]{"题目编号", "所属课程", "题目内容", "题目选项", "题目答案", "题目等级", "题目分数"});
                    jTable1.setModel(jTable1Model);

                } catch (StudentExistException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        // 删除的事件
        jButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int selectRows = jTable1.getSelectedRows().length;// 取得用户所选行的行数
                DefaultTableModel tableModel = (DefaultTableModel) jTable1
                        .getModel();
                if (selectRows >= 1) {
                    int selRowIndexs[] = jTable1.getSelectedRows();// 用户所选行的序列
                    for (int i = 0; i < selRowIndexs.length; i++) {
                        // 用tableModel.getValueAt(row, column)取单元格数据
                        String cellValue = (String) tableModel.getValueAt(
                                selRowIndexs[i], 0);
                        int tid = Integer.parseInt(cellValue);
                        titleService.delById(tid);

                        listTitle = titleList();
                        TableModel jTable1Model = new DefaultTableModel(
                                listTitle, new String[]{"题目编号", "所属课程", "题目内容",
                                "题目选项", "题目答案", "题目等级", "题目分数"});
                        jTable1.setModel(jTable1Model);
                    }
                }

            }
        });
        // 增加的事件
        jButton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                new AddTitleWindow();

            }
        });

        // 修改的事件
        jButton3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int selectRows = jTable1.getSelectedRow();// 取得用户所选行
                DefaultTableModel tableModel = (DefaultTableModel) jTable1
                        .getModel();
                String cellValue = (String) tableModel.getValueAt(
                        selectRows, 0);
                String course = (String) tableModel
                        .getValueAt(selectRows, 1);
                int tid = Integer.parseInt(cellValue);
                String question = (String) tableModel.getValueAt(
                        selectRows, 2);
                String option = (String) tableModel.getValueAt(selectRows,
                        3);
                String key = (String) tableModel.getValueAt(selectRows, 4);
                int level = Integer.parseInt((String) tableModel
                        .getValueAt(selectRows, 5));
                int score = Integer.parseInt((String) tableModel
                        .getValueAt(selectRows, 6));

                Title title = new Title();
                title.setTid(tid);
                title.setQuestion(question);
                title.setToption(option);
                title.setTkey(key);
                title.setLevel(level);
                title.setScore(score);
                title.setCourse(course);

                new UpdateTitleWindow(title);

            }
        });

        // 刷新的事件
        jButton4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                listTitle = titleList();
                TableModel jTable1Model = new DefaultTableModel(listTitle, new String[]{"题目编号", "所属课程", "题目内容", "题目选项", "题目答案", "题目等级", "题目分数"});
                jTable1.setModel(jTable1Model);
            }
        });

    }
}
