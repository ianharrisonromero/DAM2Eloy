package com.rittz.apipokemon;

public class Atraccion {
    String url;
    String nombre;
    String descripcion;
    int ocupantes;
    public String getUrl() {
        return url;
    }
    public String getNombre() {
        return nombre;
    }

    public int getOcupantes() {
        return ocupantes;
    }



    @Override
    public String toString() {
        nombre = Character.toUpperCase(nombre.charAt(0)) + nombre.substring(1);
        return nombre + "\nurl: " + url + "\nDescripcion: " + descripcion + "\nocupantes: " + ocupantes;
    }
}