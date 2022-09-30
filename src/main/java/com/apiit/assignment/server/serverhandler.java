package com.apiit.assignment.server;
import org.json.JSONObject;

import java.net.*;
import java.io.*;

public class serverhandler {
    private static Socket socket = null;
    private static ServerSocket server = null;
    private static DataInputStream  input = null;
    private static PrintWriter output;

    public static serverhandler Server(int port){
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server Initiated");
            System.out.println("Waiting");

            socket=server.accept();
            System.out.println("Connection Accepted");

            input = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            primenumclassserver prime = new primenumclassserver();
            JSONObject obj = new JSONObject();


            while ( !(obj = new JSONObject(input.readUTF())).isNull("fn")) {
                    // obj = new JSONObject(input.readUTF());
                    int clientOption = obj.getInt("fn");

                    if(clientOption == 1){
                        System.out.println("Connection Closed");
                        socket.close();
                        input.close();
                        output.close();
                    }

                    if (clientOption == 3){
                        long res = prime.nthPrime(obj.getInt("value"));
                        output.println(res);
                    }

                    if (clientOption == 4){
                        StringBuilder sb =  new StringBuilder();
                        sb.append(obj.getString("value"));
                        long res2 = prime.wordCount(sb);
                        output.println(res2);
                    }

                }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void main(String[] args) {
        serverhandler serv = Server(4090);
    }
}
