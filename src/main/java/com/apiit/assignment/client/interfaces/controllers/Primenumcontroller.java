package com.apiit.assignment.client.interfaces.controllers;


import com.apiit.assignment.client.clienthandler;

public class Primenumcontroller {
    private String res;
    public static String time;
    public String primeNumCalc(String primenum) {
        try {

            int num = Integer.parseInt(primenum);
            long startTime = System.currentTimeMillis();
            clienthandler cln = new clienthandler();
            res = String.valueOf(cln.Client(3, num, null));
            long endTime = System.currentTimeMillis();
            time = ("Duration: " + String.valueOf(endTime-startTime) + " Milliseconds" );
            return res;
        } catch (final NumberFormatException exc) {
            time = " ";
            return res = "Not a Number!";
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
