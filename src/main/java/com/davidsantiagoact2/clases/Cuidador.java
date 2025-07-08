package com.davidsantiagoact2.clases;

public class Cuidador {
    private int id_cuidador;
    private String especialidad;
    private int id_personal;
    

    public Cuidador(int id_cuidador, int id_personal, String especialidad) {
        this.id_cuidador = id_cuidador;
        this.id_personal = id_personal;
        this.especialidad = especialidad;
    }

    public int getIdCuidador() {
        return id_cuidador;
    }

    public void setIdCuidador(int id_cuidador) {
        this.id_cuidador = id_cuidador;
    }

    public int getIdpersonal(){
        return id_personal;
    }

    public void SetIdPersonal(int id_personal){
        this.id_personal = id_personal;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}