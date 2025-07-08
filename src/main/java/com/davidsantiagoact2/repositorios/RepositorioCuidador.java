package com.davidsantiagoact2.repositorios;

import com.davidsantiagoact2.Cuidador;
import java.util.List;

public interface RepositorioCuidador {
    void crear(Cuidador cuidador);
    Cuidador consultarPorId(int id);
    List<Cuidador> consultarTodos();
    void actualizar(Cuidador cuidador);
    void eliminar(int id);
}