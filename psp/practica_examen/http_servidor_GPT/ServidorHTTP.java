package http_servidor_GPT;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorHTTP {

    private static final int DEFAULT_PORT = 8765;
    private static final int RESOURCE_POSITION = 1;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT);
            System.out.println("Server started on port " + DEFAULT_PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);

                handleRequest(clientSocket);

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket clientSocket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        String header = reader.readLine();
        System.out.println("Request Header: " + header);

        String info = extractInfo(header);
        String html = generatePage(info);

        writer.write("HTTP/1.1 200 OK\n");
        writer.write("Content-Type: text/html\n\n");
        writer.write(html);
        writer.flush();

        reader.close();
        writer.close();
    }

    private static String generatePage(String info) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(info))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "<html><body><h1>Error 500: Internal Server Error</h1></body></html>";
        }
        return content.toString();
    }

    private static String extractInfo(String header) {
        String[] parts = header.split("\\s+");
        if (parts.length > RESOURCE_POSITION) {
            return parts[RESOURCE_POSITION].substring(1); // Remove leading "/"
        } else {
            return "index.html"; // Default to index.html if no specific resource requested
        }
    }
}
