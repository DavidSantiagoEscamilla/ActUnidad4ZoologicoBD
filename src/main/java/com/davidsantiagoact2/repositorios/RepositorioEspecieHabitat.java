package com.davidsantiagoact2.repositorios;

import com.davidsantiagoact2.clases.EspecieHabitat;
import java.util.List;

public interface RepositorioEspecieHabitat {
    void crear(EspecieHabitat especieHabitat);
    List<EspecieHabitat> consultarTodos();
    void eliminar(int idEspecie, int idHabitat);
}
