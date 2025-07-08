package com.davidsantiagoact2.clases;

public class Especie {
    private int idEspecie;
    private String nombreComun;
    private String nombreCientifico;

    public Especie(int idEspecie, String nombreComun, String nombreCientifico) {
        this.idEspecie = idEspecie;
        this.nombreComun = nombreComun;
        this.nombreCientifico = nombreCientifico;
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

    @Override
    public String toString() {
        return "ID: " + idEspecie + ", Nombre común: " + nombreComun + ", Nombre científico: " + nombreCientifico;
    }
}
