package com.davidsantiagoact2.repositorios;

import java.util.List;

import com.davidsantiagoact2.clases.Cuidador;

public interface RepositorioCuidador {
    void crear(Cuidador cuidador);
    Cuidador consultarPorId(int id);
    List<Cuidador> consultarTodos();
    void actualizar(Cuidador cuidador);
    void eliminar(int id);
}