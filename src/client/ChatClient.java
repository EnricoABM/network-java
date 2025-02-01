package client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.time.LocalTime;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("127.0.0.1", 5500);

            Scanner keyboard = new Scanner(System.in);
            Scanner response = new Scanner(client.getInputStream());

            PrintStream request = new PrintStream(client.getOutputStream());

            String message = "";
            do {
                System.out.print(LocalTime.now() + " - Mensagem: ");
                message = keyboard.nextLine();

                request.println(message);

                System.out.println(LocalTime.now() + " - Resposta: " + response.nextLine());
                System.out.println();
            } while (!message.isEmpty());

            client.close();
        } catch (IOException e) {
            System.out.println("Falha na comunicação, verifique a porta utilizada e/ou o estado do servidor.");
        }
    }
}
