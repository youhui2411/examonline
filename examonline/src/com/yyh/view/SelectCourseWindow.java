package com.yyh.view;

import com.yyh.service.PaperService;
import com.yyh.service.impl.PaperServiceImpl;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * @Description: com.yyh.view
 * @version: 1.0
 */
public class SelectCourseWindow extends JFrame {

    private JPanel jPanel;
    private JLabel jLabel;
    private JComboBox jComboBox;
    private JButton jButton;
    public static String SelectedCourse;//选择的课程
    private PaperService paperService = new PaperServiceImpl();

    public List<String> selCourse(){
        List<String> list = paperService.selCourse();
        return list;
    }
    public SelectCourseWindow(int uid){
        setIconImage(new ImageIcon("images/app.png").getImage());
        setTitle("非凡在线考试系统");
        jPanel = new JPanel();
        setContentPane(jPanel);
        setBounds(0, 0, 360, 200);
        List<String> list = selCourse();
        jLabel = new JLabel("请选择考试科目：");
        jComboBox = new JComboBox();
        for (int i = 0; i < list.size(); i++) {
            jComboBox.addItem(list.get(i)+"");
        }
        jButton = new JButton();
        jButton.setText("确认");

        jButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                System.out.println((String) jComboBox.getSelectedItem());
                SelectedCourse = ((String) jComboBox.getSelectedItem()).trim();

                dispose();

                new StudentWindow(uid, SelectedCourse);
            }
        });

        jPanel.add(jLabel);
        jPanel.add(jComboBox);
        jPanel.add(jButton);

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

//    public static void main(String[] args) {
//        new SelectCourseWindow();
//    }
}
