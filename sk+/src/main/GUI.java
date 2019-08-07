package main;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;

public class GUI implements ActionListener{

    public GUI(String name) {

        JFrame frame = new JFrame();
        frame.setTitle(name);
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        Font f = new Font("黑体", Font.BOLD, 28);

        JLabel welcome = new JLabel("刷课!");
        welcome.setFont(f);
        frame.add(welcome);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}