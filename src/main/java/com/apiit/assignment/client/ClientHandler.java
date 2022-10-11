package com.apiit.assignment.client;

import com.apiit.assignment.classes.networkPacket;
import org.junit.Test;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Serializable  {

    private BufferedReader input;
    private  ObjectOutputStream output;
    private Socket socket;


    public void ClientHandler(Socket socket){
        this.socket = socket;
    }

    public int Client(int funval, int reqval, StringBuilder wordCnt)throws Exception {
        socket = new Socket("localhost", 4090);
        int res = 0;
        while (socket.isConnected()) {
            try {
                System.out.println("Connected");

                output = new ObjectOutputStream(socket.getOutputStream());
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                networkPacket values = new networkPacket(funval, reqval, wordCnt);

                output.writeObject(values);
                res = input.read();
                return res;
            }catch (IOException e){
                closeCon(socket, input, output);
            }
        }
        return res;
    }

    public void closeCon(Socket socket, BufferedReader input, ObjectOutputStream output){
        try{
            if(output != null){
                output.close();
            }
            if(input != null){
                input.close();
            }
            if(socket != null){
                socket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void asynchClientTest(){

    }


}

