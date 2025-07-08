package com.davidsantiagoact2.clases;

public class Cuidador {
    private int id_cuidador;
    private String especialidad;
    private int id_personal;
    

    public Cuidador(int idCuidador, String nombre, String especialidad) {
        this.id_cuidador = id_cuidador;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public int getIdCuidador() {
        return id_cuidador;
    }

    public void setIdCuidador(int id_cuidador) {
        this.id_cuidador = id_cuidador;
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
