package com.apiit.assignment.client.interfaces.UI;

import com.apiit.assignment.client.interfaces.controllers.PrimenumGUIcontroller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimenumclassGUI implements ActionListener{

    static JTextField primeField;
    static JLabel result;
    private static JLabel time;

    static FrameGUI frameGUI = new FrameGUI();

    public static void main() {
        JPanel primepanel = frameGUI.PanelDisplay();
        JFrame primeframe = frameGUI.FrameDisplay();

        frameGUI.HeadingDisplay("Enter n:");



        primeField = new JTextField();
        primeField.setBounds(100, 50, 150, 25);
        primepanel.add(primeField);

        JButton primeNumCalc = new JButton("Calculate nth Prime");
        primeNumCalc.setBounds(95, 100, 160, 25);
        primeNumCalc.addActionListener(new PrimenumclassGUI());
        primepanel.add(primeNumCalc);

        result = new JLabel("");
        result.setBounds(125, 125, 160, 25);
        primepanel.add(result);

        time = new JLabel("");
        time.setBounds(110, 150, 160, 25);
        primepanel.add(time);

        primeframe.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PrimenumGUIcontroller pnfc = new PrimenumGUIcontroller();

        pnfc.text = primeField.getText();
        String res = pnfc.primenumintcontroller();
        String ttime = pnfc.timecalc();
        result.setText("Nth Prime is " + res);
        time.setText(ttime);
    }
}
