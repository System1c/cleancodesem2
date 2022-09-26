package com.apiit.assignment;

import javax.swing.*;
import java.awt.event.*;



public class mainInterface implements ActionListener {
    public static void main(String[] args) {
        JPanel panel1 = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.add(panel1);
        panel1.setLayout(null);

        JLabel heading = new JLabel("Welcome to AlgoJam");
        heading.setBounds(120, 25, 160, 25);
        panel1.add(heading);

        JLabel choiceHeading = new JLabel("Pick a choice below to run an algorithm");
        choiceHeading.setBounds(75, 50, 250, 25);
        panel1.add(choiceHeading);

        JButton primeNum = new JButton("nth Prime Number");
        primeNum.setBounds(10, 150, 160, 25);
        primeNum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                primeNumClass.main();
            }
        });
        panel1.add(primeNum);

        JButton wordCount = new JButton("Word Count");
        wordCount.setBounds(200, 150, 160, 25);
        wordCount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readWordCount.main();
            }
        });
        panel1.add(wordCount);

        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
