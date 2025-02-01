package server;

import server.thread.ChatServerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    public static void main(String[] args) {
        while(true) {
            try {
                ServerSocket server = new ServerSocket(5500);
                Socket client = server.accept();
                Thread thread = new ChatServerThread(client);
                thread.start();

            } catch (IOException e) {

            }
        }

    }
}
