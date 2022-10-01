package com.apiit.assignment.client.interfaces.controllers;

import com.apiit.assignment.client.clienthandler;

import java.io.*;

public class Wordcountconroller {
    private String bookcount;
    public static String booktime;

    public String bookCalc(String bookpath){
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(new File(bookpath)));
            StringBuilder book = new StringBuilder();
            fileReader.lines().forEach(line -> book.append(line).append('\n'));
            long startTime = System.currentTimeMillis();
            clienthandler cln = new clienthandler();
            String res = String.valueOf(cln.Client(4, 0, book));
            long endTime = System.currentTimeMillis();
            bookcount = ("Word count is: " + res);
            booktime = "Duration: " + String.valueOf(endTime - startTime) + " Milliseconds";
            return bookcount;
        }
        catch (IOException exc) {
            booktime = "";
            return bookcount = "Not a File!";
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
