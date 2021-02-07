package com.yyh.view;

import com.yyh.pojo.Paper;
import com.yyh.service.PaperService;
import com.yyh.service.UserService;
import com.yyh.service.impl.PaperServiceImpl;
import com.yyh.service.impl.UerServiceImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.List;


/**
 * @Description: com.yyh.view
 * @version: 1.0
 */
public class GradeManageWindow extends JFrame {
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private String[][] gradeTitle;

    //注入UserService
    private UserService userService = new UerServiceImpl();
    // 注入PaperService
    private PaperService paperService = new PaperServiceImpl();

    public String[][] gradeList() {

        System.out.println("#############################1");
        List<Paper> list = paperService.selAll();
        String gradeStr[][] = new String[list.size()][3];
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            Paper paper = list.get(i);
            System.out.println(paper);
            if(paper.getUserPoint() > -1){
                System.out.println("###################################");
                gradeStr[index][0] = paper.getPid() + "";
                gradeStr[index][1] = userService.selById(paper.getPid()).getUsername();
                gradeStr[index++][2] = paper.getUserPoint() + "";
            }
        }
        return gradeStr;
    }

    public GradeManageWindow() {

        //设置一下主题
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        setIconImage(new ImageIcon("images/app.png").getImage());
        setTitle("成绩管理");//成绩管理


        try {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

            setResizable(false);

            jPanel1 = new JPanel();
            getContentPane().add(jPanel1, BorderLayout.CENTER);

            jScrollPane1 = new JScrollPane();

            gradeTitle = gradeList();
            TableModel jTable1Model = new DefaultTableModel(gradeTitle, new String[]{"学生编号", "学生姓名", "学生成绩"});//, "试卷编号"

            jTable1 = new JTable();
            jScrollPane1.setViewportView(jTable1);
            jTable1.setModel(jTable1Model);
            jTable1.setBounds(7, 25, 685, 337);


            GroupLayout gl_jPanel1 = new GroupLayout(jPanel1);
            gl_jPanel1.setHorizontalGroup(
                    gl_jPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(gl_jPanel1.createSequentialGroup()
                                    .addGap(7)
                                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 685, GroupLayout.PREFERRED_SIZE))
                            .addGroup(gl_jPanel1.createSequentialGroup()
                                    .addGap(79)
            ));
            gl_jPanel1.setVerticalGroup(
                    gl_jPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(gl_jPanel1.createSequentialGroup()
                                    .addGap(25)
                                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
                                    .addGap(24)
                            )        .addGroup(gl_jPanel1.createParallelGroup(GroupLayout.Alignment.LEADING)
            ));
            jPanel1.setLayout(gl_jPanel1);

            pack();
            this.setSize(715, 468);
            setLocationRelativeTo(null);
            setVisible(true);


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

    public static void main(String[] args) {
        new GradeManageWindow();
    }

}
