package com.apiit.assignment.client.interfaces.UI;

import com.apiit.assignment.client.interfaces.controllers.PrimenumGUIcontroller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimenumclassGUI implements ActionListener{

    static JTextField primeField;
    static JLabel result;
    private static JLabel time;
    public static void main() {
        JPanel primePanel = new JPanel();
        JFrame primeFrame = new JFrame();
        primeFrame.setSize(400,400);
        primeFrame.setVisible(true);
        primeFrame.add(primePanel);
        primePanel.setLayout(null);

        JLabel heading = new JLabel("Enter n:");
        heading.setBounds(150, 25, 160, 25);
        primePanel.add(heading);

        primeField = new JTextField();
        primeField.setBounds(100, 50, 150, 25);
        primePanel.add(primeField);

        JButton primeNumCalc = new JButton("Calculate nth Prime");
        primeNumCalc.setBounds(95, 100, 160, 25);
        primeNumCalc.addActionListener(new PrimenumclassGUI());
        primePanel.add(primeNumCalc);

        result = new JLabel("");
        result.setBounds(125, 125, 160, 25);
        primePanel.add(result);

        time = new JLabel("");
        time.setBounds(110, 150, 160, 25);
        primePanel.add(time);

        primeFrame.setVisible(true);
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
