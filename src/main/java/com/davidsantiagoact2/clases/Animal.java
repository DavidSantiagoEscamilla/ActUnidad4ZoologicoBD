package com.davidsantiagoact2.clases;

public class Animal {
    private int idAnimal;
    private String nombre;
    private int edad;
    private String sexo;

    public Animal(int idAnimal, String nombre, int edad, String sexo) {
        this.idAnimal = idAnimal;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "ID: " + idAnimal + ", Nombre: " + nombre + ", Edad: " + edad + ", Sexo: " + sexo;
    }
}
