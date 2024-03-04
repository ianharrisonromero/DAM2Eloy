package http_servidor_multifuncional;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorHttpMultifuncional {

    private static final int DEFAULT_PORT = 8888;
    // primer split()
    private static final int RESOURCE_POSITION = 1;
    // segundo split()
    private static final int OPERATION_POSITION = 1;
    private static final int FIRST_OPERAND = 2;
    private static final int SECOND_OPERAND = 3;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(DEFAULT_PORT);

        while (true) {
            Socket clientConnexion = server.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientConnexion.getInputStream()));
            String requestLine = reader.readLine();

            // Comprobar si el requestLine es null o vacío
            if (requestLine == null || requestLine.isEmpty()) {
                // Cerrar recursos y seguir a la siguiente iteración
                reader.close();
                clientConnexion.close();
                continue;
            }

            System.out.println("'RequestLine': " + requestLine);
            String[] info = extractInfo(requestLine);

            String html = generateWebPage(info);

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientConnexion.getOutputStream()));

            writer.write(html);
            writer.flush();

            // Close resources and connection
            reader.close();
            writer.close();
            clientConnexion.close();
        }
    }

    private static String generateWebPage(String[] info) {
        String str = "HTTP/1.1 200 OK\n";
        str += "Content-Type: application/json\n\n"; // parece decirla al browser que es un .json
        int resultado;

        if (info[OPERATION_POSITION].toLowerCase().equals("suma")
                || info[OPERATION_POSITION].toLowerCase().equals("resta")
                || info[OPERATION_POSITION].toLowerCase().equals("multiplicacion")
                || info[OPERATION_POSITION].toLowerCase().equals("division")) {

            try {
                switch (info[OPERATION_POSITION]) {
                    case "suma":
                        resultado = Integer.parseInt(info[FIRST_OPERAND]) + Integer.parseInt(info[SECOND_OPERAND]);
                        break;
                    case "resta":
                        resultado = Integer.parseInt(info[FIRST_OPERAND]) + Integer.parseInt(info[SECOND_OPERAND]);
                        break;
                    case "multiplicacion":
                        resultado = Integer.parseInt(info[FIRST_OPERAND]) * Integer.parseInt(info[SECOND_OPERAND]);
                        break;
                    case "division":
                        if (Integer.parseInt(info[SECOND_OPERAND]) != 0) {
                            resultado = Integer.parseInt(info[FIRST_OPERAND]) / Integer.parseInt(info[SECOND_OPERAND]);
                        } else {
                            str = "HTTP/1.1 404 Not Found\n\n";
                            return str;
                        }
                        break;
                    default:
                        str = "HTTP/1.1 400 Bad Request\n\n";
                        return str;
                }
                try {
                    System.out.println("resultado: " + resultado);

                } catch (Exception e) {
                    // TODO: handle exception
                }

                str += "{\n\t\"operando 1\": \"" + info[FIRST_OPERAND] + "\",\n\t\"operando 2\": \""
                        + info[SECOND_OPERAND]
                        + "\",\n\t\"operacion\": \"" + info[OPERATION_POSITION] + "\",\n\t\"resultado\": " + resultado
                        + "\n}";

                return str;

            } catch (NumberFormatException e) {
                str = "HTTP/1.1 403 Forbidden\n\n";
                return str;
            }

        }

        // PARA VER SI ES PRIMO

        if (info[OPERATION_POSITION].toLowerCase().equals("primo")) {
            Integer numPrime = Integer.parseInt(info[FIRST_OPERAND]);
            String primeText = "";

            if (esPrimo(numPrime)) {
                primeText = "El número " + numPrime + " SÍ es primo.";
            } else {
                primeText = "El número " + numPrime + " NO es primo.";
            }

            try {
                System.out.println(primeText);
            } catch (Exception e) {
                // TODO: handle exception
            }

            str += "{\n\t\"numero recibido\": \"" + info[FIRST_OPERAND] + "\",\n\t\"resultado\": " + esPrimo(numPrime)
                    + "\n}";

            return str;

        }

        if (info[OPERATION_POSITION].toLowerCase().equals("amayusculas")) {
            String textoEnMayusculas = info[FIRST_OPERAND].toUpperCase();
            str += textoEnMayusculas;

            return str.replaceAll("%20", " ");
            // También se podría utilizar un <p> o <h4> supongo (introducirlos al principio
            // y al final de "str")
        }

        if (info[OPERATION_POSITION].toLowerCase().equals("aminusculas")) {
            String textoEnMayusculas = info[FIRST_OPERAND].toLowerCase();
            str += textoEnMayusculas;

            return str.replaceAll("%20", " ");
            // También se podría utilizar un <p> o <h4> supongo (introducirlos al principio
            // y al final de "str")
        }

        // GENERAR NUMERO ALEATORIO
        if (info[OPERATION_POSITION].toLowerCase().equals("generaraleatorio")) {

            int rango_max = Integer.parseInt(info[SECOND_OPERAND]);
            int rango_min = Integer.parseInt(info[FIRST_OPERAND]);
            int i = (int) (Math.random() * (rango_max - rango_min + 1)) + rango_min;
            String textoNumAleatorio = String.format("Número aleatorio generado entre el %d y el %d : %d", rango_max,
                    rango_min, i);
            return str += textoNumAleatorio;
            // También se podría utilizar un <p> o <h4> supongo (introducirlos al principio
            // y al final de "str")
        }

        return str;

    }

    private static String[] extractInfo(String requestLine) {
        String[] result;
        result = requestLine.split(" ");
        result = result[RESOURCE_POSITION].trim().split("/"); // importante doble split
        return result;
    }

    public static boolean esPrimo(Integer random) {
        if (random <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(random); i++) {
            if (random % i == 0) {
                return false;
            }
        }
        return true;
    }
}