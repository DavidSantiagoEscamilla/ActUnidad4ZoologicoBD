package com.davidsantiagoact2.clases;

public class Cuidado {
    private int idAnimal;
    private int idCuidador;

    public Cuidado(int idAnimal, int idCuidador) {
        this.idAnimal = idAnimal;
        this.idCuidador = idCuidador;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public int getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(int idCuidador) {
        this.idCuidador = idCuidador;
    }
}
