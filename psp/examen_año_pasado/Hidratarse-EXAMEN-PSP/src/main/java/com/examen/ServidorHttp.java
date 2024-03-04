package com.examen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServidorHttp {
    public static void main(String[] args) {
        int puerto = Integer.parseInt(args[0]);

        try (ServerSocket ServerSocket = new ServerSocket(puerto);) {
            System.out.println("Servidor iniciado");
            while (true) {
                Socket socket = ServerSocket.accept();
                new Thread(new GestionClientes(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // clase que gestiona el cliente
    public static class GestionClientes implements Runnable {
        private final Socket SOCKET;
        private int n;
        private int m;

        public GestionClientes(Socket socket) {
            SOCKET = socket;
        }

        @Override
        public void run() {
            try {
                procesarPeticion();
                procesarRespuesta();
                SOCKET.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void procesarRespuesta() throws IOException {
            String response;

            String contenido = construirHtml();
            // respuesta http
            response = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: text/html\r\n"
                    + "Content-Length: " + contenido.length() + "\r\n"
                    + "\r\n"
                    + contenido;

            PrintWriter out = new PrintWriter(SOCKET.getOutputStream(), true);
            out.println(response);
        }

        private String construirHtml() {
            StringBuilder html = new StringBuilder();
            List<Integer> primos = generarPrimos();
            html.append("<ul>\n");
            for (Integer primo : primos) {
                html.append("<li>" + primo + "</li>");
                html.append("\n");
            }
            html.append("</ul>\n");
            System.out.println(html.toString());
            return html.toString();
        }

        public List<Integer> generarPrimos() {
            List<Integer> primos = new ArrayList<>();
            for (int i = n; i < m; i++) {
                if (comprobarPrimo(i)) {
                    primos.add(i);
                }
            }
            return primos;
        }

        // metodo generar que desde n, m veces genere numeros y los devuelve en una
        // lista
        private void procesarPeticion() throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(SOCKET.getInputStream()));
            String lineaPeticion = in.readLine();
            System.out.println(lineaPeticion);

            // "//s" separa cualquier espacio en blanco o tabulacion
            String[] tokens = lineaPeticion.split("\\s");
            String[] numeros = tokens[1].split("/"); // separo los numeros
            n = Integer.parseInt(numeros[1]);
            m = Integer.parseInt(numeros[2]);
            System.out.println(n + " " + m);
        }

        private static Boolean comprobarPrimo(int num) {
            if (num <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
