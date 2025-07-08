package com.davidsantiagoact2;

public class DetalleItinerario {
    private int idItinerario;
    private int idGuia;

    public DetalleItinerario() {}

    public DetalleItinerario(int idItinerario, int idGuia) {
        this.idItinerario = idItinerario;
        this.idGuia = idGuia;
    }

    public int getIdItinerario() {
        return idItinerario;
    }

    public void setIdItinerario(int idItinerario) {
        this.idItinerario = idItinerario;
    }

    public int getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(int idGuia) {
        this.idGuia = idGuia;
    }
}
