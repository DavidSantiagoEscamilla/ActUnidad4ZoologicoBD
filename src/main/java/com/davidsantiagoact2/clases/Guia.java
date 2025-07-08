package com.davidsantiagoact2.clases;

public class Guia {
    private int idGuia;
    private String nombre;
    private String idioma;

    public Guia(int idGuia, String nombre, String idioma) {
        this.idGuia = idGuia;
        this.nombre = nombre;
        this.idioma = idioma;
    }

    public int getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(int idGuia) {
        this.idGuia = idGuia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}
