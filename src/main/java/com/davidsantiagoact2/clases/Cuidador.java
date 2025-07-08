package com.davidsantiagoact2.clases;

public class Cuidador {
    private int idCuidador;
    private String nombre;
    private String especialidad;

    public Cuidador(int idCuidador, String nombre, String especialidad) {
        this.idCuidador = idCuidador;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public int getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(int idCuidador) {
        this.idCuidador = idCuidador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
