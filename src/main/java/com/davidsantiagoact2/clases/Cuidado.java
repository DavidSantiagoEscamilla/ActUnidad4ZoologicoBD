package com.davidsantiagoact2.clases;

import java.time.LocalDate;

public class Cuidado {
    private int idPersonal;
    private int idAnimal;
    private LocalDate fecha;

    public Cuidado(int idPersonal, int idAnimal, LocalDate fecha) {
        this.idPersonal = idPersonal;
        this.idAnimal = idAnimal;
        this.fecha = fecha;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Personal: " + idPersonal + " - Animal: " + idAnimal + " - Fecha: " + fecha;
    }
}
