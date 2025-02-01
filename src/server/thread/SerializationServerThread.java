package server.thread;

import model.Message;
import server.SerializationServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.UUID;

public class SerializationServerThread extends Thread {

    private Socket client;

    public SerializationServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream request = new ObjectInputStream(client.getInputStream());
            Message message = (Message) request.readObject();
            System.out.println(message);

            ObjectOutputStream response = new ObjectOutputStream(client.getOutputStream());
            message.setToken(this.generateToken());
            response.writeObject(message);

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateToken() {
        return UUID.randomUUID().toString();
    }
}
