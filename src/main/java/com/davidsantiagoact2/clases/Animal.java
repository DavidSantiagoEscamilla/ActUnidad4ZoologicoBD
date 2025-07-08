package com.davidsantiagoact2.clases;

import java.time.LocalDate;

public class Animal {
    private int idAnimal;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String sexo;
    private int idEspecie;
    private int idHabitat;
    private int idPersonal;

    public Animal(int idAnimal, String nombre, LocalDate fechaNacimiento, String sexo, int idEspecie, int idHabitat, int idPersonal) {
        this.idAnimal = idAnimal;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.idEspecie = idEspecie;
        this.idHabitat = idHabitat;
        this.idPersonal = idPersonal;
    }

    public int getIdAnimal() { return idAnimal; }
    public String getNombre() { return nombre; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public String getSexo() { return sexo; }
    public int getIdEspecie() { return idEspecie; }
    public int getIdHabitat() { return idHabitat; }
    public int getIdPersonal() { return idPersonal; }

    
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public void setSexo(String sexo) { this.sexo = sexo; }
    public void setIdEspecie(int idEspecie) { this.idEspecie = idEspecie; }
    public void setIdHabitat(int idHabitat) { this.idHabitat = idHabitat; }
    public void setIdPersonal(int idPersonal) { this.idPersonal = idPersonal; }

    @Override
    public String toString() {
        return "ID: " + idAnimal +
               ", Nombre: " + nombre +
               ", Fecha Nacimiento: " + fechaNacimiento +
               ", Sexo: " + sexo +
               ", ID Especie: " + idEspecie +
               ", ID Hábitat: " + idHabitat +
               ", ID Personal: " + idPersonal;
    }
}
