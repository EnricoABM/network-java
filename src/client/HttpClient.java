package client;

import model.RequestHttp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HttpClient {

    public static void main(String[] args) {
        System.out.println("Cliente Iniciado...");
        Scanner keyboard = new Scanner(System.in);
        String cep;
        do {
            System.out.print("Informe o CEP: ");
            cep = keyboard.nextLine();
            cep = cep.replace("-", "");
        } while(cep.length() != 8);

        try {
            System.out.println("Criando Requisição Http...");
            RequestHttp request = new RequestHttp();
            request.setMethod("GET");
            request.setUri("/ws/" + cep + "/json/");
            request.setHttpVersion("HTTP/1.1");
            request.addHeader("Accept", "application/json");
            request.addHeader("Host", "viacep.com.br");

            HttpClient client = new HttpClient();
            System.out.println("Requisição Enviada...");

            LocalTime before = LocalTime.now();
            String response = client.send(request, "viacep.com.br", 80);
            LocalTime after = LocalTime.now();

            Long timeDif = before.until(after, ChronoUnit.SECONDS);

            System.out.println();
            System.out.println(response);

            System.out.println("Tempo de resposta: " + timeDif + "s");
        } catch (IOException e) {
            System.out.println("Falha ao enviar a requisição");
        }

    }

    public String send(RequestHttp request, String address, Integer port) throws IOException {
        Socket client = new Socket(address, port);
        PrintStream ps = new PrintStream(client.getOutputStream());

        String requestBody = this.createRequestBody(request);

        ps.print(requestBody);
        ps.flush();

        String response = this.readResponse(client);
        client.close();
        return response;
    }

    private String readResponse(Socket client) throws IOException {
        BufferedReader response = new BufferedReader(new InputStreamReader(client.getInputStream()));
        StringBuilder responseString = new StringBuilder();

        String line;
        while((line = response.readLine()) != null) {
            responseString.append(line);
            responseString.append("\n");
        }

        return responseString.toString();
    }

    private String createRequestBody(RequestHttp request) {
        StringBuilder requestString = new StringBuilder();
        requestString
                .append(request.getMethod())
                .append(" ")
                .append(request.getUri())
                .append(" ")
                .append(request.getHttpVersion())
                .append("\r\n");

        Set<Map.Entry<String, String>> headers = request.getHeaders().entrySet();
        for (Map.Entry<String, String> header: headers) {
            requestString
                    .append(header.getKey())
                    .append(": ")
                    .append(header.getValue())
                    .append("\r\n");
        }
        requestString.append("\r\n");
        return requestString.toString();
    }
}
