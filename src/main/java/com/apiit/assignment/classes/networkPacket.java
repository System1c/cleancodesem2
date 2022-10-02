package com.apiit.assignment.classes;

import java.io.Serializable;

public class networkPacket implements Serializable {
    public int functionVal;
    public int requestVal;
    public StringBuilder wordCount;


    public networkPacket(int functionVal, int requestVal, StringBuilder wordCount ) {
        this.functionVal = functionVal;
        this.requestVal = requestVal;
        this.wordCount = wordCount;
    }



}
