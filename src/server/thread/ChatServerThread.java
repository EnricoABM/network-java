package server.thread;

import java.io.*;
import java.net.Socket;
import java.time.LocalTime;
import java.util.Scanner;

/**
 * Thread para responder diversas requisições ao mesmo tempo
 * */
public class ChatServerThread extends Thread {
    private Socket client;

    public ChatServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        System.out.println("Cliente conectado: " + client.getInetAddress().getHostName());
        Scanner keyboard = new Scanner(System.in);

        try {
            PrintStream response = new PrintStream(client.getOutputStream());

            BufferedReader data = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String message = "";
            do {
                message = data.readLine();
                System.out.println(LocalTime.now() + " - Mensagem: " + message);
                System.out.print(LocalTime.now() + " - Resposta: ");
                response.println(keyboard.nextLine());
                System.out.println();
            } while(!message.isEmpty());
            client.close();

        } catch (IOException e) {
            System.out.println(this.getId() + ": Falha na conexão");;
        }
    }
}
