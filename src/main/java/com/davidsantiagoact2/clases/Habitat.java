package com.davidsantiagoact2.clases;

public class Habitat {
    private int idHabitat;
    private String nombre;
    private String clima;
    private int idZona;

    public Habitat(int idHabitat, String nombre, String clima, int idZona) {
        this.idHabitat = idHabitat;
        this.nombre = nombre;
        this.clima = clima;
        this.idZona = idZona;
    }

    public int getIdHabitat() {
        return idHabitat;
    }

    public void setIdHabitat(int idHabitat) {
        this.idHabitat = idHabitat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public int getIdZona() {
        return idZona;
    }

    public void setIdZona(int idZona) {
        this.idZona = idZona;
    }

    @Override
    public String toString() {
        return "ID: " + idHabitat + " - " + nombre + " (" + clima + ") Zona: " + idZona;
    }
}
