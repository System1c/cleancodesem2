package com.apiit.assignment;

import org.json.*;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class clienthandler{

    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;
    private BufferedReader in;
    private int res;


    public int Client(JSONObject obj){
        try {
            socket = new Socket("localhost", 4090);
            System.out.println("Connected");
            input = new DataInputStream(System.in);
            out = new DataOutputStream(socket.getOutputStream());

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(obj);
            out.writeUTF(obj.toString());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            return res = Integer.parseInt(in.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                    socket.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}

