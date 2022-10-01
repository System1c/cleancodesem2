package com.apiit.assignment.server;
import com.apiit.assignment.classes.networkPacket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class threadmanager implements Runnable, Serializable {
    private static Socket socket = null;
    private static ServerSocket server = null;
    private static int port = 4090;
    private PrintWriter output;

    public networkPacket values;

    @Override
    public void run() {
        try
        {
            server = new ServerSocket(port);
            while (true){
                System.out.println("Server Initiated");
                System.out.println("Waiting");

                socket=server.accept();
                System.out.println("Connection Accepted");


                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                output = new PrintWriter(socket.getOutputStream(), true);

                try{
                    while ((values = (networkPacket) input.readObject()) != null){
                        primenumclassserver ncm = new primenumclassserver();
                        if(values.functionVal == 3){
                            int res = (int) ncm.nthPrime(values.requestVal);
                            output.write(res);
                            output.flush();
                        }
                        if(values.functionVal == 4){
                            StringBuilder sb = new StringBuilder(values.wordCount);
                            System.out.println(sb);
                            int res = (int) ncm.wordCount(sb);
                            output.write(res);
                            output.flush();
                        }

                    }

                }catch (EOFException e){
                    output.close();
                    input.close();
                    socket.close();
                }
            }

        }

        catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
