package com.apiit.assignment.client.interfaces.UI;

import com.apiit.assignment.client.interfaces.controllers.WordcountGUIcontroller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WordcountGUI implements ActionListener{

    private static JTextField wordField;
    private static JLabel wordResult;
    private static JLabel wordTime;

    static FrameGUI frameGUI = new FrameGUI();

    public static void main() {
        JPanel countpanel = frameGUI.PanelDisplay();
        JFrame countframe = frameGUI.FrameDisplay();

        frameGUI.HeadingDisplay("Enter the path of the book text:");

        wordField = new JTextField();
        wordField.setBounds(100, 50, 150, 25);
        countpanel.add(wordField);

        JButton wordCalc = new JButton("Calculate number of words");
        wordCalc.setBounds(85, 100, 190, 25);
        wordCalc.addActionListener(new WordcountGUI());
        countpanel.add(wordCalc);

        wordResult = new JLabel("");
        wordResult.setBounds(125, 125, 160, 25);
        countpanel.add(wordResult);

        wordTime = new JLabel("");
        wordTime.setBounds(110, 150, 160, 25);
        countpanel.add(wordTime);

        countframe.setVisible(true);
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

