package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI {

    public GUI(String name) {

        JFrame frame = new JFrame(name);
        frame.setSize(300, 100);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();

        Font f = new Font("黑体", Font.BOLD, 28);

        JButton StartButton = new JButton();
        StartButton.setText("开刷");
        StartButton.setFont(f);

        JButton ArrangeButton = new JButton();
        ArrangeButton.setText("管理订单");
        ArrangeButton.setFont(f);
        ArrangeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new GUI_ArrangeOrders().Show();
            }
        });

        panel.add(StartButton);
        panel.add(ArrangeButton);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}