package main;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;

public class GUI implements ActionListener{

    final JMenu[] m = {new JMenu("课程管理"), new JMenu("订单管理"), new JMenu("用户管理"), new JMenu("查询功能"), new JMenu("系统")};
    final JMenuItem[][] mm = {{new JMenuItem("查看课程数据"),
            new JMenuItem("添加课程数据"),
            new JMenuItem("删除课程数据"),
            new JMenuItem("更改课程数据")},
            {new JMenuItem("查看课程数据"),
                    new JMenuItem("添加订单数据"),
                    new JMenuItem("删除订单数据"),
                    new JMenuItem("更改订单数据")},
            {new JMenuItem("查看订单数据"),
                    new JMenuItem("添加用户数据"),
                    new JMenuItem("删除用户数据"),
                    new JMenuItem("更改用户数据")},
            {new JMenuItem("查询学生成绩"), new JMenuItem("查询课程成绩")},
            {new JMenuItem("关于"),
                    new JMenuItem("退出")}};

    public GUI(String name) {

        JFrame frame = new JFrame();
        JMenuBar mb = new JMenuBar();

        for(int i=0; i<m.length; i++) {
            for(int j=0; j<mm[i].length; j++) {
                m[i].add(mm[i][j]);
                mm[i][j].addActionListener(this);
            }
            mb.add(m[i]);
        }

        frame.setJMenuBar(mb);
        frame.setTitle(name);
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        Font f = new Font("黑体", Font.BOLD, 28);

        JLabel welcome = new JLabel("       欢迎使用刷课后台管理系统!");
        welcome.setFont(f);
        frame.add(welcome);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //系统
        if(e.getActionCommand() == "关于") {
            JOptionPane.showMessageDialog(null, "瞎几把搞工作室 版权所有", "声明", JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getActionCommand() == "退出") {
            System.exit(0);
        }

        //课程管理
        if(e.getActionCommand() == "查看课程数据") {
            new GUI_Course.ViewCourse();
        }
        if(e.getActionCommand() == "添加课程数据") {
            new GUI_Course.AddCourse();
        }
        if(e.getActionCommand() == "删除课程数据") {
            new GUI_Course.DeleteCourse();
        }
        if(e.getActionCommand() == "更改课程数据") {
            new GUI_Course.UpdateCourse();
        }

        //订单管理
        if(e.getActionCommand() == "查看订单数据") {
            //new GUI_Course.ViewCourse();
        }
        if(e.getActionCommand() == "添加订单数据") {
            //new GUI_Course.AddCourse();
        }
        if(e.getActionCommand() == "删除订单数据") {
            //new GUI_Course.DeleteCourse();
        }
        if(e.getActionCommand() == "更改订单数据") {
            //new GUI_Course.UpdateCourse();
        }

        //用户管理
        if(e.getActionCommand() == "查看用户数据") {
            //new GUI_SCourse.ViewSCourse();
        }
        if(e.getActionCommand() == "添加用户数据") {
            //new GUI_SCourse.AddSCourse();
        }
        if(e.getActionCommand() == "删除用户数据") {
            //new GUI_SCourse.DeleteSCourse();
        }
        if(e.getActionCommand() == "更改用户数据") {
            //new GUI_SCourse.UpdateSCourse();
        }

        //查询功能
        if(e.getActionCommand() == "查询学生成绩") {
            //new GUI_Functions.StuGrades();
        }
        if(e.getActionCommand() == "查询课程成绩") {
            //new GUI_Functions.CrsGrades();
        }
    }

}
