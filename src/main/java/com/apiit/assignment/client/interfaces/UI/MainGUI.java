package com.apiit.assignment.client.interfaces.UI;
import com.apiit.assignment.client.interfaces.controllers.PrimenumGUIcontroller;
import com.apiit.assignment.client.interfaces.controllers.WordcountGUIcontroller;

import javax.swing.*;
import java.awt.event.*;



public class MainGUI implements ActionListener {
        static FrameGUI frameGUI = new FrameGUI();
    public static void main(String[] args) {
        JPanel panel1 = frameGUI.PanelDisplay();
        JFrame frame = frameGUI.FrameDisplay();

        frameGUI.HeadingDisplay("Welcome to AlgoJam");
        frameGUI.SubheadingDisplay("Pick a choice below to run an algorithm");

        JButton primeNum = new JButton("nth Prime Number");
        primeNum.setBounds(10, 150, 160, 25);
        primeNum.addActionListener(e -> {
            frame.dispose();
            new PrimenumGUIcontroller().run();
        });
        panel1.add(primeNum);

        JButton wordCount = new JButton("Word Count");
        wordCount.setBounds(200, 150, 160, 25);
        wordCount.addActionListener(e -> {
            frame.dispose();
            new WordcountGUIcontroller().run();
        });
        panel1.add(wordCount);

        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
