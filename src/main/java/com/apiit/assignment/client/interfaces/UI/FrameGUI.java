package com.apiit.assignment.client.interfaces.UI;


import javax.swing.*;

public class FrameGUI{
    private JPanel panel1 = new JPanel();


    public JPanel PanelDisplay(){
        panel1 = new JPanel();
        panel1.setLayout(null);
        return panel1;
    }

    public JFrame FrameDisplay(){
        JFrame frame = new JFrame();
        frame.setSize(400,400);
        frame.setVisible(true);
        frame.add(panel1);
        return frame;
    }

    public void HeadingDisplay(String heading){
        JLabel label = new JLabel(heading);
        label.setBounds(100, 25, 250, 25);
        panel1.add(label);
    }

    public void SubheadingDisplay(String subheading){
        JLabel label = new JLabel(subheading);
        label.setBounds(75, 50, 250, 25);
        panel1.add(label);
    }


}
