package com.examen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

//LIBRERIA USADA APACHE COMMONS PARA EL MAIL
public class CifradoCorreos {
    private static final String SERVIDOR = "smtp.educa.madrid.org";
    private static final int PORT = 587;
    private static final String REMITENTE = "miguelseusarnetcat@gmail.com";
    private static final String SUBJECT = "Examen";
    private static final String MSG_ENVIADO = "Correo electrónico enviado exitosamente.";

    public static void main(String[] args) {

        String rutaMensajes = args[0];
        String rutaDirecciones = args[1];

        int rotacion = Integer.parseInt(args[2]);

        String user = args[3];
        String password = args[4];

        List<String> listaMensajes = extraerLineas(rutaMensajes);
        List<String> listaDirecciones = extraerLineas(rutaDirecciones);

        gestionEnvio(listaMensajes, listaDirecciones, rotacion, user, password);

    }

    private static void gestionEnvio(List<String> listaMensajes,
            List<String> listaDirecciones, int rotacion, String user, String password) {
        List<String> mensajesCifrados = cifrarLista(listaMensajes, rotacion);
        for (int i = 0; i < listaDirecciones.size(); i++) {
            String contenido = mensajesCifrados.get(i);
            String direccion = listaDirecciones.get(i);
            enviarCorreo(contenido, direccion, user, password);
        }
    }

    private static void enviarCorreo(String contenido, String direccion, String user, String password) {
        Email email = new SimpleEmail();

        email.setHostName(SERVIDOR);
        email.setSmtpPort(PORT);

        email.setAuthentication(user, password);
        email.setSSLOnConnect(true);
        try {
            email.setFrom(REMITENTE);
            email.setSubject(SUBJECT);
            email.setMsg(contenido);
            email.addTo(direccion);
            email.send();
            System.out.println(MSG_ENVIADO);
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

    private static List<String> cifrarLista(List<String> listaMensajes, int rotacion) {
        List<String> listaCifrada = new ArrayList<>();
        for (String mensaje : listaMensajes) {
            String cifrado = cifrarMensaje(mensaje, rotacion);
            listaCifrada.add(cifrado);
        }
        return listaCifrada;
    }

    private static String cifrarMensaje(String mensaje, int rotacion) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < mensaje.length(); i++) {
            char caracter = mensaje.charAt(i);
            if (Character.isLetter(caracter)) {
                int posicion = caracter - (Character.isUpperCase(caracter) ? 'A' : 'a');
                posicion = (posicion + rotacion + 26) % 26;
                caracter = (char) (posicion + (Character.isUpperCase(caracter) ? 'A' : 'a'));
                rotacion++;
            }
            resultado.append(caracter);
        }
        return resultado.toString();
    }

    private static List<String> extraerLineas(String ruta) {
        List<String> lista = new ArrayList<>();
        File file = new File(ruta);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String ln;
            while ((ln = br.readLine()) != null) {
                lista.add(ln);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return lista;
    }
}