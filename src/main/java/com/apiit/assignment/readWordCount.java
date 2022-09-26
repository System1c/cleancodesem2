package com.apiit.assignment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class readWordCount implements ActionListener{

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
        wordCalc.addActionListener(new readWordCount());
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
        NonConcurrentAlgorithms algorithms = new NonConcurrentAlgorithms();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String path = wordField.getText();
            BufferedReader fileReader = new BufferedReader(new FileReader(new File(path)));
            StringBuilder book = new StringBuilder();
            fileReader.lines().forEach(line -> book.append(line).append('\n'));
            long startTime = System.currentTimeMillis();
            String res = String.valueOf(algorithms.wordCount(book));
            long endTime = System.currentTimeMillis();
            wordResult.setText("Word count is: " + res);
            wordTime.setText("Duration: " + String.valueOf(endTime - startTime) + " Milliseconds");
        } catch (IOException exc) {
            wordResult.setText("Not a File!");
            wordTime.setText("");
        }
    }
}

