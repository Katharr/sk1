package main;

import javax.swing.*;
import javax.swing.table.TableColumn;

public class GUI_ArrangeOrders {

    public void Show() {

        JFrame frame = new JFrame("管理订单");
        frame.setBounds(300,300, 600, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();

        Object[][] obj = DBSystem.VisitSql.SelectClass();
        String[] columnNames = {"课程编号", "课程平台", "课程名称", "课程单价"};
        JTable table = new JTable(obj, columnNames);
        TableColumn column = null;
        int columns = table.getColumnCount();
        for(int i=0; i<columns; i++) {
            column = table.getColumnModel().getColumn(i);
            column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(100);
        }
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setEnabled(false);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setSize(300,200);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }

}
