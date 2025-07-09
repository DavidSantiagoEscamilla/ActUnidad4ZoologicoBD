package com.davidsantiagoact2.repositorios;

import com.davidsantiagoact2.clases.ExamenMedico;
import java.util.List;

public interface RepositorioExamenMedico {
    void crear(ExamenMedico examen);
    List<ExamenMedico> consultarTodos();
    ExamenMedico consultarPorId(int id);
    void actualizar(ExamenMedico examen);
    void eliminar(int id);
}
