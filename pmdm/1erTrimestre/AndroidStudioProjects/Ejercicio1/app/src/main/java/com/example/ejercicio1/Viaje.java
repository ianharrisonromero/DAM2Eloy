package com.example.ejercicio1;

import java.io.Serializable;

public class Viaje implements Serializable {
    String origen, destino, fechaIda, fechaVuelta;
    boolean soloIda = false;

    public Viaje(String origen, String destino, String fechaIda, String fechaVuelta) {
        this.origen = origen;
        this.destino = destino;
        this.fechaIda = fechaIda;
        this.fechaVuelta = fechaVuelta;
    }

    public Viaje(String origen, String fechaIda, boolean soloIda) {
        this.origen = origen;
        this.fechaIda = fechaIda;
        this.soloIda = soloIda;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getFechaIda() {
        return fechaIda;
    }

    public String getFechaVuelta() {
        return fechaVuelta;
    }

    public boolean isSoloIda() {
        return soloIda;
    }
}
