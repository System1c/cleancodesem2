package com.apiit.assignment.server;
import org.json.JSONObject;

import java.net.*;
import java.io.*;

public class serverhandler extends threadmanager{


    public void Server(){

    }

    public static void main(String[] args) {
        Runnable ot = new threadmanager();
        Thread th = new Thread(ot);
        th.start();
    }


}
