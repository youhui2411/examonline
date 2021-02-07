package com.yyh.view;

import com.yyh.exception.StudentExistException;
import com.yyh.pojo.User;
import com.yyh.service.PaperService;
import com.yyh.service.UserService;
import com.yyh.service.impl.PaperServiceImpl;
import com.yyh.service.impl.UerServiceImpl;
import com.yyh.util.ImportUserUtil;

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
public class StudentManageWindow extends JFrame {

    private JPanel jPanel1;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton4;
    private JScrollPane jScrollPane1;
    private JButton jButton3;
    private JTable jTable1;
    private String[][] listTitle;

    private static UserService userService = new UerServiceImpl();
    // 注入PaperManage
    private PaperService paperService = new PaperServiceImpl();

    public static String[][] titleList() {

        List<User> listUser = userService.selAll();
        int size = listUser.size();
        String userStr[][] = new String[size][4];
        for (int i = 0; i < listUser.size(); i++) {
            User user = listUser.get(i);
            System.out.println(user);
            userStr[i][0] = user.getUid() + "";
            userStr[i][1] = user.getUsername();
            userStr[i][2] = user.getPassword();
            if (user.getPaperId() != 0) {
                userStr[i][3] = user.getPaperId() + "";
            }


        }

        return userStr;
    }

    public StudentManageWindow() {
        setIconImage(new ImageIcon("images/app.png").getImage());
        setTitle("\u5B66\u751F\u7BA1\u7406");


        try {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

            jPanel1 = new JPanel();
            getContentPane().add(jPanel1, BorderLayout.CENTER);

            jScrollPane1 = new JScrollPane();

            listTitle = titleList();
            TableModel jTable1Model = new DefaultTableModel(
                    listTitle, new String[]{"学生编号", "学生姓名", "学生密码", "试卷编号"});

            jTable1 = new JTable();
            jScrollPane1.setViewportView(jTable1);
            jTable1.setModel(jTable1Model);
            jTable1.setBounds(7, 25, 685, 337);


            jButton1 = new JButton();
            jButton1.setText("删除");


            jButton3 = new JButton();
            jButton3.setText("修改");


            jButton4 = new JButton();
            jButton4.setText("\u5237\u65b0");


            jButton2 = new JButton();
            jButton2.setText("\u5bfc\u5165\u5b66\u751f");

            GroupLayout gl_jPanel1 = new GroupLayout(jPanel1);
            gl_jPanel1.setHorizontalGroup(
                    gl_jPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(gl_jPanel1.createSequentialGroup()
                                    .addGap(7)
                                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 685, GroupLayout.PREFERRED_SIZE))
                            .addGroup(gl_jPanel1.createSequentialGroup()
                                    .addGap(79)
                                    .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                    .addGap(70)
                                    .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                    .addGap(78)
                                    .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                    .addGap(80)
                                    .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
            );
            gl_jPanel1.setVerticalGroup(
                    gl_jPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(gl_jPanel1.createSequentialGroup()
                                    .addGap(25)
                                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
                                    .addGap(24)
                                    .addGroup(gl_jPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
            );
            jPanel1.setLayout(gl_jPanel1);

            pack();
            this.setSize(715, 468);
            setLocationRelativeTo(null);
            setVisible(true);

            // 导入学生的事件

            jButton2.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    ImportUserUtil iu = new ImportUserUtil();
                    try {

                        //userService.setAuto_increment(1001);
                        iu.insertUser(iu.getStudents());

                        listTitle = titleList();
                        TableModel jTable1Model = new DefaultTableModel(
                                listTitle, new String[]{"学生编号", "学生姓名",
                                "学生密码", "试卷编号"});
                        jTable1.setModel(jTable1Model);
                        jButton2.setEnabled(false);

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
                            if (tid == 1000) {
                                JOptionPane.showMessageDialog(StudentManageWindow.this,
                                        "管理员不能被删除");
                                break;
                            }
                            userService.delById(tid);
                            paperService.delById(tid);
                            listTitle = titleList();
                            TableModel jTable1Model = new DefaultTableModel(
                                    listTitle, new String[]{"学生编号", "学生姓名",
                                    "学生密码", "试卷编号"});
                            jTable1.setModel(jTable1Model);
                            //只有管理员的时候 将导入按钮设置为可用
                            if (userService.selAll().size() == 1) {
                                jButton2.setEnabled(true);
                            }
                        }
                    }

                }
            });

            // 修改的事件
            jButton3.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    int selectRows = jTable1.getSelectedRow();// 取得用户所选行
                    DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
                    String cellValue = (String) tableModel.getValueAt(selectRows, 0);
                    int tid = Integer.parseInt(cellValue);
                    String name = (String) tableModel.getValueAt(selectRows, 1);
                    String password = (String) tableModel.getValueAt(selectRows, 2);
                    int paper = Integer.parseInt((String) tableModel.getValueAt(selectRows, 3));

                    User user = new User();
                    user.setUid(tid);
                    user.setUsername(name);
                    user.setPassword(password);

                    new UpdateStudentWindow(user, paper);

                }
            });

            // 刷新的事件
            jButton4.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub


                    listTitle = titleList();
                    TableModel jTable1Model = new DefaultTableModel(listTitle,
                            new String[]{"学生编号", "学生姓名", "学生密码", "试卷编号"});
                    jTable1.setModel(jTable1Model);
                }
            });
        } catch (Exception e) {
            // add your error handling code here
            e.printStackTrace();
        }


    }

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

}
