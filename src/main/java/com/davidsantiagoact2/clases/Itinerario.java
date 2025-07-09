package com.davidsantiagoact2.clases;

public class Itinerario {
    private int idItinerario;
    private String nombre;
    private String descripcion;
    private int duracionMinutos;
    private int idGuia;

    public Itinerario(int idItinerario, String nombre, String descripcion, int duracionMinutos, int idGuia) {
        this.idItinerario = idItinerario;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionMinutos = duracionMinutos;
        this.idGuia = idGuia;
    }

    public int getIdItinerario() {
        return idItinerario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public int getIdGuia() {
        return idGuia;
    }

    @Override
    public String toString() {
        return "ID: " + idItinerario + " - " + nombre + " (" + duracionMinutos + " min) - Guía: " + idGuia;
    }
}
