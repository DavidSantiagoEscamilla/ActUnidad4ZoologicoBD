package com.davidsantiagoact2.repositorios;

import com.davidsantiagoact2.clases.Habitat;
import java.util.List;

public interface RepositorioHabitat {
    void crear(Habitat habitat);
    List<Habitat> consultarTodos();
    void eliminar(int idHabitat);
}
