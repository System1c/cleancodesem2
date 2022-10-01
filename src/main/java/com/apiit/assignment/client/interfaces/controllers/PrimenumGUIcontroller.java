package com.apiit.assignment.client.interfaces.controllers;


import com.apiit.assignment.client.interfaces.UI.PrimenumclassGUI;

public class PrimenumGUIcontroller implements Runnable {
    static PrimenumclassGUI primeNumClass = new PrimenumclassGUI();
    public static String text;


    public void primeintconstructor(String text) {
        this.text = text;
    }


    public String primenumintcontroller(){
        String primeres = new Primenumcontroller().primeNumCalc(text);
        return primeres;
    }

    public String timecalc(){
        String time = Primenumcontroller.time;
        return time;
    }

    @Override
    public void run() {
        primeNumClass.main();

    }

}
