package com.davidsantiagoact2.clases;

import java.time.LocalDate;

public class ExamenMedico {
    private int idExamen;
    private String tipoExamen;
    private String resultado;
    private int idAnimal;
    private LocalDate fecha;

    public ExamenMedico(int idExamen, String tipoExamen, String resultado, int idAnimal, LocalDate fecha) {
        this.idExamen = idExamen;
        this.tipoExamen = tipoExamen;
        this.resultado = resultado;
        this.idAnimal = idAnimal;
        this.fecha = fecha;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public String getTipoExamen() {
        return tipoExamen;
    }

    public String getResultado() {
        return resultado;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setTipoExamen(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "ID: " + idExamen +
               ", Tipo: " + tipoExamen +
               ", Resultado: " + resultado +
               ", ID Animal: " + idAnimal +
               ", Fecha: " + fecha;
    }
}
