package com.davidsantiagoact2.clases;

public class Especie {
    private int idEspecie;
    private String nombreComun;
    private String nombreCientifico;
    private String tipo;

    public Especie(int idEspecie, String nombreComun, String nombreCientifico, String tipo) {
        this.idEspecie = idEspecie;
        this.nombreComun = nombreComun;
        this.nombreCientifico = nombreCientifico;
        this.tipo = tipo;
    }

    public int getIdEspecie() {
        return idEspecie;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    @Override
    public String toString() {
        return "ID: " + idEspecie + ", Nombre común: " + nombreComun + ", Nombre científico: " + nombreCientifico;
    }
}
