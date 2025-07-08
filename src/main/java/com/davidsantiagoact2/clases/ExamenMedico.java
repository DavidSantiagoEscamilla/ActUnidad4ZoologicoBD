package com.davidsantiagoact2;

import java.util.Date;

public class ExamenMedico {
    private int idExamen;
    private Date fecha;
    private String resultado;

    public ExamenMedico(int idExamen, Date fecha, String resultado) {
        this.idExamen = idExamen;
        this.fecha = fecha;
        this.resultado = resultado;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
