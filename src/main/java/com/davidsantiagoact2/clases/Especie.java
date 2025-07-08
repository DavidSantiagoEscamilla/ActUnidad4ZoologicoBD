package com.davidsantiagoact2.clases;

public class Especie {
    private int idEspecie;
    private String nombreCientifico;
    private String nombreComun;
    private String tipo;

    public Especie(int idEspecie, String nombreCientifico, String nombreComun, String tipo) {
        this.idEspecie = idEspecie;
        this.nombreCientifico = nombreCientifico;
        this.nombreComun = nombreComun;
        this.tipo = tipo;
    }

    public int getIdEspecie() {
        return idEspecie;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return idEspecie + " - " + nombreComun + " (" + nombreCientifico + ") - Tipo: " + tipo;
    }
}
