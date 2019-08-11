package main;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.TableColumn;

import main.DBSystem.VisitSql;

public class GUI_Order {
    final static int MAX = 20;

    public static class ViewOrder {

        public ViewOrder() {
            JFrame frame = new JFrame("查看订单数据");
            frame.setSize(500, 350);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setVisible(true);

            Object[][] obj = VisitSql.SelectCourse();
            String[] columnNames = {"订单编号", "用户编号", "课程编号", "帐号", "密码", "完成状态", "进行状态"};
            JTable table = new JTable(obj, columnNames);
            TableColumn column = null;
            int columns = table.getColumnCount();
            for(int i=0; i<columns; i++) {
                column = table.getColumnModel().getColumn(i);
                column.setPreferredWidth(100);
            }
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            table.setEnabled(false);

            JScrollPane scroll = new JScrollPane(table);
            scroll.setSize(300,200);

            frame.add(scroll);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(true);

        }

    }

    //todo
    public static class AddOrder {

        public static class AddButtonListener implements ActionListener {

            public JTextField ClassId, ClassPlat, ClassName, Price;

            public AddButtonListener(JTextField classId, JTextField classPlat, JTextField className, JTextField price) {
                this.ClassId = classId;
                this.ClassPlat = classPlat;
                this.ClassName = className;
                this.Price = price;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                String id = ClassId.getText().trim();
                String plat = ClassPlat.getText().trim();
                String name = ClassName.getText().trim();
                String price = Price.getText().trim();
                boolean flag = true;
                if(id.equals("")) {
                    JOptionPane.showMessageDialog(null, "课程编号不可为空!", "错误", JOptionPane.ERROR_MESSAGE);
                    flag = false;
                    return;
                }
                if(plat.equals("")) {
                    JOptionPane.showMessageDialog(null, "课程平台不可为空!", "错误", JOptionPane.ERROR_MESSAGE);
                    flag = false;
                    return;
                }
                if(name.equals("")) {
                    JOptionPane.showMessageDialog(null, "课程名称不可为空!", "错误", JOptionPane.ERROR_MESSAGE);
                    flag = false;
                    return;
                }
                if(price.equals("")) {
                    JOptionPane.showMessageDialog(null, "课程单价不可为空!", "错误", JOptionPane.ERROR_MESSAGE);
                    flag = false;
                    return;
                }
                VisitSql s = new VisitSql();
                if(flag) {
                    if(s.AddCourse(id, plat, name, price))
                        JOptionPane.showMessageDialog(null,"信息添加成功!","成功",JOptionPane.INFORMATION_MESSAGE);
                    else JOptionPane.showMessageDialog(null, "课程编号不可重复!", "错误", JOptionPane.ERROR_MESSAGE);
                }
            }

        }

        public AddCourse() {
            JFrame frame = new JFrame("添加课程数据");
            frame.setSize(500, 350);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);

            JPanel panel = new JPanel();
            panel.setLayout(null);

            //添加课程编号
            JLabel ClassId = new JLabel("请输入要添加的课程编号: ");
            ClassId.setBounds(10,50,200,40);
            panel.add(ClassId);

            JTextField ClassIdText = new JTextField(20);
            ClassIdText.setBounds(220,60,200,30);
            panel.add(ClassIdText);

            //添加课程平台
            JLabel ClassPlat = new JLabel("请输入要添加的课程平台: ");
            ClassPlat.setBounds(10,100,200,40);
            panel.add(ClassPlat);

            JTextField ClassPlatText = new JTextField(20);
            ClassPlatText.setBounds(220,110,200,30);
            panel.add(ClassPlatText);

            //添加课程名称
            JLabel ClassName = new JLabel("请输入要添加的课程名称: ");
            ClassName.setBounds(10,150,200,40);
            panel.add(ClassName);

            JTextField ClassNameText = new JTextField(20);
            ClassNameText.setBounds(220,160,200,30);
            panel.add(ClassNameText);

            //添加课程单价
            JLabel Price = new JLabel("请输入要添加的课程单价: ");
            Price.setBounds(10,200,200,40);
            panel.add(Price);

            JTextField PriceText = new JTextField(20);
            PriceText.setBounds(220,210,200,30);
            panel.add(PriceText);

            JButton confirm = new JButton("确认");
            AddButtonListener lis = new AddButtonListener(ClassIdText, ClassPlatText, ClassNameText, PriceText);
            confirm.addActionListener(lis);
            confirm.setBounds(200, 280, 80, 25);
            panel.add(confirm);

            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(true);

        }

    }

    public static class DeleteButtonListener implements ActionListener {

        public JTextField text = new JTextField();

        public DeleteButtonListener(JTextField text) {
            this.text = text;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String tt = text.getText().trim();
            VisitSql s = new VisitSql();
            boolean flag = false;
            if(tt.equals("")) {
                JOptionPane.showMessageDialog(null, "课程编号不可为空!", "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Object[][] obj = VisitSql.SelectCourse();
            for(int i=0, j=0; obj[i][j] != null; i++) {
                if(obj[i][j].equals(tt))
                    flag = true;
            }
            if(flag) {
                if(s.DeleteCourse(tt)) JOptionPane.showMessageDialog(null, "信息删除成功!", "成功", JOptionPane.INFORMATION_MESSAGE);
                else JOptionPane.showMessageDialog(null, "该指令违背完整性约束!", "失败!", JOptionPane.ERROR_MESSAGE);
            }
            else JOptionPane.showMessageDialog(null, "课程编号不存在!", "错误", JOptionPane.ERROR_MESSAGE);

        }

    }

    public static class DeleteCourse {

        public DeleteCourse() {
            JFrame frame = new JFrame("删除课程数据");
            frame.setSize(500, 350);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);

            JPanel panel = new JPanel();
            panel.setLayout(null);

            JLabel label = new JLabel("请输入要删除的课程编号: ");
            label.setBounds(150,50,200,40);
            panel.add(label);

            JTextField text = new JTextField(20);
            text.setBounds(140,100,165,25);
            panel.add(text);

            JButton button = new JButton("确认");
            DeleteButtonListener lis = new DeleteButtonListener(text);
            button.addActionListener(lis);
            button.setBounds(190, 150, 80, 25);
            panel.add(button);

            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(true);

        }

    }

    public static class UpdateButtonListener implements ActionListener {

        public JTextField ClassId, ClassPlat, ClassName, Price;

        public UpdateButtonListener(JTextField classId, JTextField classPlat, JTextField className, JTextField price) {
            this.ClassId = classId;
            this.ClassPlat = classPlat;
            this.ClassName = className;
            this.Price = price;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String id = ClassId.getText().trim();
            String plat = ClassPlat.getText().trim();
            String name = ClassName.getText().trim();
            String price = Price.getText();

            if(id.equals("")) {
                JOptionPane.showMessageDialog(null, "课程编号不能为空!", "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(plat.equals("")) {
                JOptionPane.showMessageDialog(null, "课程平台不能为空!", "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(name.equals("")) {
                JOptionPane.showMessageDialog(null, "课程名称不能为空!", "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(price.equals("")) {
                JOptionPane.showMessageDialog(null, "课程单价不能为空!", "错误", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean flag = false;
            VisitSql s = new VisitSql();
            Object[][] obj = VisitSql.SelectCourse();
            for(int i=0, j=0; obj[i][j] != null; i++) {
                if(obj[i][j].equals(id)) flag = true;
            }
            if(flag && s.UpdateCourse(id, plat, name, price))
                JOptionPane.showMessageDialog(null, "信息修改成功!", "成功", JOptionPane.INFORMATION_MESSAGE);
            else JOptionPane.showMessageDialog(null, "课程编号不存在!", "失败", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static class UpdateCourse {

        public UpdateCourse() {
            JFrame frame = new JFrame("更改课程数据");
            frame.setSize(500, 350);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);

            JPanel panel = new JPanel();
            panel.setLayout(null);

            //课程数据
            JLabel ClassId = new JLabel("请输入要修改的课程编号: ");
            ClassId.setBounds(10,50,200,40);
            panel.add(ClassId);

            JTextField ClassIdText = new JTextField(20);
            ClassIdText.setBounds(220,60,200,30);
            panel.add(ClassIdText);

            //课程平台
            JLabel ClassPlat = new JLabel("请输入要修改的课程平台: ");
            ClassPlat.setBounds(10,100,200,40);
            panel.add(ClassPlat);

            JTextField ClassPlatText = new JTextField(20);
            ClassPlatText.setBounds(220,110,200,30);
            panel.add(ClassPlatText);

            //课程名称
            JLabel ClassName = new JLabel("请输入要修改的课程名称: ");
            ClassName.setBounds(10,150,200,40);
            panel.add(ClassName);

            JTextField ClassNameText = new JTextField(20);
            ClassNameText.setBounds(220,160,200,30);
            panel.add(ClassNameText);

            //课程单价
            JLabel Price = new JLabel("请输入要修改的课程单价: ");
            Price.setBounds(10,200,200,40);
            panel.add(Price);

            JTextField PriceText = new JTextField(20);
            PriceText.setBounds(220,210,200,30);
            panel.add(PriceText);

            JButton confirm = new JButton("确认");
            UpdateButtonListener lis = new UpdateButtonListener(ClassIdText, ClassPlatText, ClassNameText, PriceText);
            confirm.addActionListener(lis);
            confirm.setBounds(200, 260, 80, 25);
            panel.add(confirm);

            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(true);

        }

    }
}
