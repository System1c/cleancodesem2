package com.apiit.assignment.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;



    public Server(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }

    public void startServer(){
        try{
            while(!serverSocket.isClosed()){
                Socket socket = serverSocket.accept();
                ClientServerHandler threadmanager = new ClientServerHandler(socket);
                threadmanager.start();
            }
        } catch (Exception e){
            closeServerSocket();
        }
    }

    public void closeServerSocket(){
        try{
            if(serverSocket != null){
                serverSocket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4090);
        Server serverhandler = new Server(serverSocket);
        serverhandler.startServer();
    }


}
