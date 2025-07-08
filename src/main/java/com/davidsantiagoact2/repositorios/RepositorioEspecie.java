package com.davidsantiagoact2.repositorios;

import com.davidsantiagoact2.clases.Especie;
import java.util.List;

public interface RepositorioEspecie {
    void crear(Especie especie);
    List<Especie> obtenerTodas();
    Especie buscarPorId(int id);
    void actualizar(Especie especie);
    void eliminar(int id);
}
