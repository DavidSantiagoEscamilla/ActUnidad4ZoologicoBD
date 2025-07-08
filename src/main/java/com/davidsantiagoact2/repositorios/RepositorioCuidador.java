package com.davidsantiagoact2.repositorios;

import com.davidsantiagoact2.clases.Cuidador;
import java.util.List;

public interface RepositorioCuidador {
    void crear(Cuidador cuidador);
    List<Cuidador> consultarTodos();
    Cuidador consultarPorId(int id);
    void actualizar(Cuidador cuidador);
    void eliminar(int id);
}
