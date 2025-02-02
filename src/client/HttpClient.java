package client;

import model.RequestHttp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Map;
import java.util.Set;

public class HttpClient {

    public static void main(String[] args) {
        try {
            RequestHttp request = new RequestHttp();
            request.setMethod("GET");
            request.setUri("/ws/01001000/json/");
            request.setHttpVersion("HTTP/1.1");
            request.addHeader("Accept", "application/json");
            request.addHeader("Host", "viacep.com.br");

            HttpClient client = new HttpClient();
            String response = client.send(request, "viacep.com.br", 80);
            System.out.println(response);
        } catch (IOException e) {

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
