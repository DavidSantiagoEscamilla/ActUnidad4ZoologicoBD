package com.davidsantiagoact2.clases;

public class ZonaItinerario {
    private int idZona;
    private int idItinerario;

    public ZonaItinerario(int idZona, int idItinerario) {
        this.idZona = idZona;
        this.idItinerario = idItinerario;
    }

    public int getIdZona() {
        return idZona;
    }

    public void setIdZona(int idZona) {
        this.idZona = idZona;
    }

    public int getIdItinerario() {
        return idItinerario;
    }

    public void setIdItinerario(int idItinerario) {
        this.idItinerario = idItinerario;
    }
}
