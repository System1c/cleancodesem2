package com.apiit.assignment.client;

import com.apiit.assignment.classes.networkPacket;
import java.io.*;
import java.net.Socket;

public class clienthandler implements Serializable  {

    private BufferedReader input;
    private  ObjectOutputStream output;
    private Socket socket;
    public int Client(int funval, int reqval, StringBuilder wordCnt)throws Exception {

        try {
            socket = new Socket("localhost", 4090);
            System.out.println("Connected");

            output = new ObjectOutputStream(socket.getOutputStream());
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            networkPacket values = new networkPacket(funval, reqval, wordCnt);

            output.writeObject(values);
            int res = input.read();
            return res;
        } finally {
            output.close();
            input.close();
            socket.close();
        }
    }
}

