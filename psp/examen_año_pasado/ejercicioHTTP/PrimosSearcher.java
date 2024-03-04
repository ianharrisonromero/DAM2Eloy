package examen_año_pasado.ejercicioHTTP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class PrimosSearcher implements Runnable {

    public Socket socket;
    public int n;
    public int m;
    private final int RESOURCES_NUMBER = 2;
    private final int S_RESOURCE_POSITION = 1;
    List<Integer> listaPrimos = new ArrayList<>();
    static List<PrimoObserver> observers = new ArrayList<>();

    public PrimosSearcher(Socket socket, int n, int m) {
        this.socket = socket;
        this.n = n;
        this.m = m;
    }

    @Override
    public void run() {
        try {
            // Thread.sleep(5000);  
            listaPrimos = searchListaPrimos();
            handleRequest(socket, listaPrimos);

        } catch (Exception e) {
        }

    }

    private void handleRequest(Socket socket, List<Integer> listaPrimos) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String html = generatePage(listaPrimos);

        writer.write("HTTP/1.1 200 OK\n");
        writer.write("Content-Type: text/html\n\n");
        writer.write(html);
        writer.flush();

        writer.close();
    }

    public List<Integer> searchListaPrimos() {
        int primosContador = 0;
        for (int i = n + 1; primosContador < m; i++) {
            if (esPrimo(i)) {
                listaPrimos.add(i);
                primosContador++;
                notifyObservers(i);
                // ESTO NO SE SI ESTÁ BIEN, SERÍA UN NOTIFY DIRECTAMENTE??
            }
        }
        return listaPrimos;
    }

    public static boolean esPrimo(Integer number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static String generatePage(List<Integer> listaPrimos) {
        StringBuilder content = new StringBuilder();
        try {
            // AQUI EL BUSCAR PRIMOS Y ESO
            content.append("<ul>\n");
            for (Integer primo : listaPrimos) {
                content.append("<li>" + primo + "</li>\n");
            }
            content.append("</ul>");
        } catch (Exception e) {
            e.printStackTrace();
            return "<html><body><h1>Error 500: Internal Server Error</h1></body></html>";
        }
        return content.toString();
    }

    public static void addObserver(PrimoObserver observer) {
        observers.add(observer);
    }

    public static void removeObserver(PrimoObserver observer) {
        observers.remove(observer);
    }

    private static void notifyObservers(int primo) {
        for (PrimoObserver observer : observers) {
            observer.update(primo);
        }
    }

}
