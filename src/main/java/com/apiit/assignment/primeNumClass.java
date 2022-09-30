package com.apiit.assignment;
import org.json.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class primeNumClass implements ActionListener {

    private static JTextField primeField;
    private static JLabel result;
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
        primeNumCalc.addActionListener(new primeNumClass());
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
        NonConcurrentAlgorithms algorithms = new NonConcurrentAlgorithms();

        try {


            int num = Integer.parseInt(primeField.getText());
            long startTime = System.currentTimeMillis();


            // String res = String.valueOf(algorithms.nthPrime(num));

            JSONObject obj = new JSONObject();
            obj.put("fn", 3);
            obj.put("value", num);
            clienthandler cln = new clienthandler();
            String res = String.valueOf(cln.Client(obj));

            long endTime = System.currentTimeMillis();
            result.setText("Nth Prime is " + res);
            time.setText("Duration: " + String.valueOf(endTime-startTime) + " Milliseconds" );
        } catch (final NumberFormatException exc) {
            result.setText("Not a Number!");
            time.setText("");
        }

    }
}
