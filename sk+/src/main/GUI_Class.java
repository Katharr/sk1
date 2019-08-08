package main;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.TableColumn;

import main.DBSystem.VisitSql;

public class GUI_Class {

    final static int MAX = 20;

    public static class ViewClass {

        public ViewClass() {

            JFrame frame = new JFrame("查询课程信息");
            frame.setSize(500, 350);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setVisible(true);

            Object[][] obj = VisitSql.SelectClass();
            String[] columnNames = {"ClassId", "ClassPlat", "ClassName", "Price"};
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

            JButton button = new JButton("打印");
            button.setBounds(340, 30, 80, 25);
            frame.add(button);

            frame.add(scroll);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(true);

        }

    }

}
