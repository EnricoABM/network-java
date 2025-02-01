package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class HttpClient {
    public static void main(String[] args) {
        try {
            Socket cliente = new Socket("127.0.0.1", 8080);

            PrintStream ps = new PrintStream(cliente.getOutputStream());

            ps.print("GET /nome/Enrico HTTP/1.1\r\n");
            ps.print("Host: localhost\r\n");
            ps.print("Connection: close\r\n");  // Indica ao servidor que pode fechar a conexão
            ps.print("\r\n");  // Fim dos cabeçalhos
            ps.flush();  // Garante que tudo foi enviado

            BufferedReader response = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

            String linha;
            while ((linha = response.readLine()) != null) {
                System.out.println(linha);
            }

            cliente.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
