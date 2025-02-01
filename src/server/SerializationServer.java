package server;

import server.thread.SerializationServerThread;

import java.io.IOException;
import java.net.ServerSocket;

public class SerializationServer {
    public static void main(String[] args) {
        try {
            System.out.println("Servidor Iniciando...");
            ServerSocket server = new ServerSocket(7000);
            SerializationServerThread thread = new SerializationServerThread(server.accept());
            thread.start();
        } catch (IOException e) {

        }

    }
}
