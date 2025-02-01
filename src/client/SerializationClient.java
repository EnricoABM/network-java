package client;

import model.Message;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLOutput;

public class SerializationClient {
    public static void main(String[] args) {
        Message message = new Message("User12345", "Bom dia!, gostaria de ajuda com um dúvida...");
        System.out.println(message);
        try {
            Socket client = new Socket("127.0.0.1", 7000);
            ObjectOutputStream request = new ObjectOutputStream(client.getOutputStream());
            request.writeObject(message);

            ObjectInputStream response = new ObjectInputStream(client.getInputStream());
            System.out.println(response.readObject());
            client.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
