package com.apiit.assignment.client.interfaces.UI;

import com.apiit.assignment.client.interfaces.controllers.PrimenumGUIcontroller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimenumclassGUI implements ActionListener{

    static JTextField primeField;
    static JLabel result;
    private static JLabel time;
    static JTable table;
    static DefaultTableModel model;

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

        String column[]={"Number","Result"};


        model = new DefaultTableModel(column, 0);
        table = new JTable(model);
        table.setEnabled(false);
        JScrollPane sp=new JScrollPane(table);
        sp.setBounds(100,175,160,150);
        primepanel.add(sp);

        primeframe.setVisible(true);
        primeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PrimenumGUIcontroller pnfc = new PrimenumGUIcontroller();

        pnfc.text = primeField.getText();
        String res = pnfc.primenumintcontroller();
        String ttime = pnfc.timecalc();

        model.addRow(new Object[]{pnfc.text, res});

        result.setText("Nth Prime is " + res);
        time.setText(ttime);



    }

}
