package com.apiit.assignment.client.interfaces.UI;

import com.apiit.assignment.client.interfaces.controllers.WordcountGUIcontroller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WordcountGUI implements ActionListener{

    private static JTextField wordField;
    private static JLabel wordResult;
    private static JLabel wordTime;
    public static void main() {
        JPanel wordPanel = new JPanel();
        JFrame wordFrame = new JFrame();
        wordFrame.setSize(400,400);
        wordFrame.setVisible(true);
        wordFrame.add(wordPanel);
        wordPanel.setLayout(null);

        JLabel wordheading = new JLabel("Enter the path of the book text:");
        wordheading.setBounds(90, 25, 250, 25);
        wordPanel.add(wordheading);

        wordField = new JTextField();
        wordField.setBounds(100, 50, 150, 25);
        wordPanel.add(wordField);

        JButton wordCalc = new JButton("Calculate number of words");
        wordCalc.setBounds(85, 100, 190, 25);
        wordCalc.addActionListener(new WordcountGUI());
        wordPanel.add(wordCalc);

        wordResult = new JLabel("");
        wordResult.setBounds(125, 125, 160, 25);
        wordPanel.add(wordResult);

        wordTime = new JLabel("");
        wordTime.setBounds(110, 150, 160, 25);
        wordPanel.add(wordTime);

        wordFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        WordcountGUIcontroller wcc = new WordcountGUIcontroller();
        wcc.path =  wordField.getText();
        String res = wcc.bookpathcalc();
        String ttime = wcc.booktimecalc();
        wordResult.setText(res);
        wordTime.setText(ttime);
    }
}

