package com.examen;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class CuadradoUDP {
    private final static int MAX_LENGTH = 65507;
    private final static String FIN = "FIN";
    private final static String MENSAJE_ENCENDIDO = "Escuchando en el puerto... :";
    private final static String MENSAJE_RECIBO = "Valores recibidos de :";
    private final static String SUFIJO_BROADCAST = ".255";
    private final static String CARACTER_SEPARACION = "\\s";
    private static final int NUM_VALORES = 3;

    public static void main(String[] args) {
        int puertoEscucha = Integer.parseInt(args[0]);
        int puertoEnvio = Integer.parseInt(args[1]);

        try (DatagramSocket socket = new DatagramSocket(puertoEscucha)) {
            System.out.println(MENSAJE_ENCENDIDO + puertoEscucha);
            byte[] buffer = new byte[MAX_LENGTH];
            DatagramPacket paquete = new DatagramPacket(buffer, MAX_LENGTH);

            String valores = "";
            do {
                socket.receive(paquete);
                valores = recibirValores(paquete); // Formato [numero] [numero] [caracter]
                InetAddress ipPaquete = paquete.getAddress();
                System.out.println(MENSAJE_RECIBO + ipPaquete + ": " + valores);
                gestionarRespuesta(socket, puertoEnvio, valores, ipPaquete);
            } while (!valores.equalsIgnoreCase(FIN));

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void gestionarRespuesta(DatagramSocket socket, int puertoEnvio, String valores,
            InetAddress ipPaquete) throws IOException {
        InetAddress ipBroadcast = transformarIp(ipPaquete);
        List<String> listaValores = extraerValores(valores);
        String cuadrado = generadorCuadrados(listaValores);
        enviarRespuesta(socket, ipBroadcast, puertoEnvio, cuadrado);
    }

    private static void enviarRespuesta(DatagramSocket socket, InetAddress ipBroadcast, int puertoEnvio,
            String cuadrado) throws IOException {
        byte mensaje[] = cuadrado.getBytes();
        DatagramPacket paqueteEnvio = new DatagramPacket(
                mensaje,
                mensaje.length,
                ipBroadcast,
                puertoEnvio);
        socket.send(paqueteEnvio);
    }

    private static List<String> extraerValores(String valores) {
        List<String> listaValores = new ArrayList<>();
        String arrayValores[] = valores.split(CARACTER_SEPARACION);
        for (int i = 0; i < NUM_VALORES; i++) {
            listaValores.add(arrayValores[i]);
        }
        return listaValores;
    }

    private static InetAddress transformarIp(InetAddress ipPaquete) {
        String ip = ipPaquete.getHostAddress();
        String primerosTres = ip.substring(0, ip.lastIndexOf(".")); // 192.168.1
        ip = primerosTres + SUFIJO_BROADCAST;
        InetAddress ipBroadcast;
        try {
            ipBroadcast = InetAddress.getByName(ip);
            return ipBroadcast;
        } catch (UnknownHostException e) {
            return null;
        }
    }

    private static String recibirValores(DatagramPacket paquete) {
        return new String(paquete.getData(), 0, paquete.getLength());
    }

    public static String generadorCuadrados(List<String> listaValores) {
        int altura = Integer.parseInt(listaValores.get(0));
        int anchura = Integer.parseInt(listaValores.get(1));
        String caracter = listaValores.get(2);
        StringBuilder cuadrado = new StringBuilder();

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < anchura; j++) {
                if (i == 0 || i == altura - 1 || j == 0 || j == altura - 1) {
                    cuadrado.append(caracter);
                } else {
                    cuadrado.append(" ");
                }
            }
            cuadrado.append("\n");
        }
        return cuadrado.toString();
    }
}