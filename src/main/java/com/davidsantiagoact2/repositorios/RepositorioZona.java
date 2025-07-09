package com.davidsantiagoact2.repositorios;

import com.davidsantiagoact2.clases.Zona;
import java.util.List;

public interface RepositorioZona {
    void crear(Zona zona);
    List<Zona> consultarTodos();
    void eliminar(int idZona);
}
