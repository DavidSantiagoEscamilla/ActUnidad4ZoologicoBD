package com.davidsantiagoact2.repositorios;

import com.davidsantiagoact2.clases.Cuidado;
import java.util.List;

public interface RepositorioCuidado {
    void crear(Cuidado cuidado);
    List<Cuidado> consultarTodos();
    void eliminar(int idPersonal, int idAnimal);
}
