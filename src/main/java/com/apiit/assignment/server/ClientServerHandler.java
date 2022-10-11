package com.apiit.assignment.server;
import com.apiit.assignment.classes.networkPacket;

import java.io.*;
import java.net.Socket;

public class ClientServerHandler extends Thread implements Runnable, Serializable   {
    private static Socket socket;

    public networkPacket values;



    public ClientServerHandler(Socket socket){
        try{
            ClientServerHandler.socket = socket;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try
        {
            while (true){
                System.out.println("Server Initiated");
                System.out.println("Waiting");

                System.out.println("Connection Accepted");


                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                try{
                    while ((values = (networkPacket) input.readObject()) != null){
                        Concurrentalgorithms cam = new Concurrentalgorithms();
                        if(values.functionVal == 3){
                            int res = (int) cam.nthPrime(values.requestVal);
                            output.write(res);
                            output.flush();
                        }
                        if(values.functionVal == 4){
                            StringBuilder sb = new StringBuilder(values.wordCount);
                            int res = (int) cam.wordCount(sb);
                            output.write(res);
                            output.flush();
                        }
                    }

                }catch (EOFException e){
                    closeServer(socket, output, input);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeServer(Socket socket, PrintWriter output, ObjectInputStream input){
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
}
