package com.davidsantiagoact2.repositorios;

import com.davidsantiagoact2.clases.Itinerario;
import java.util.List;

public interface RepositorioItinerario {
    void crear(Itinerario itinerario);
    List<Itinerario> consultarTodos();
    void eliminar(int id);
}
