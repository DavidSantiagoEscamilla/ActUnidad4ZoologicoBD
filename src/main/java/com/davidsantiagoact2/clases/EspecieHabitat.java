package com.davidsantiagoact2.clases;

public class EspecieHabitat {
    private int idEspecie;
    private int idHabitat;

    public EspecieHabitat(int idEspecie, int idHabitat) {
        this.idEspecie = idEspecie;
        this.idHabitat = idHabitat;
    }

    public int getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(int idEspecie) {
        this.idEspecie = idEspecie;
    }

    public int getIdHabitat() {
        return idHabitat;
    }

    public void setIdHabitat(int idHabitat) {
        this.idHabitat = idHabitat;
    }

    @Override
    public String toString() {
        return "Especie: " + idEspecie + ", Hábitat: " + idHabitat;
    }
}
