package com.davidsantiagoact2;

public class ExamenAnimal {
    private int idExamen;
    private int idAnimal;

    public ExamenAnimal(int idExamen, int idAnimal) {
        this.idExamen = idExamen;
        this.idAnimal = idAnimal;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }
}

