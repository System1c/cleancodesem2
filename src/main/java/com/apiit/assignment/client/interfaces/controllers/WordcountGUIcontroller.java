package com.apiit.assignment.client.interfaces.controllers;

import com.apiit.assignment.client.interfaces.UI.WordcountGUI;

public class WordcountGUIcontroller implements Runnable {

    public static String path;

    public void bookpathconstructor(String path) {
        this.path = path;
    }


    public String bookpathcalc(){
        String bookres = new Wordcountconroller().bookCalc(path);
        return bookres;
    }

    public String booktimecalc(){
        String time = Wordcountconroller.booktime;
        return time;
    }

    @Override
    public void run() {
        WordcountGUI.main();
    }
}
