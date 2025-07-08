package com.davidsantiagoact2;

import java.util.List;

public interface RepositorioAnimal {
    void crear(Animal animal);
    Animal consultarPorId(int id);
    List<Animal> consultarTodos();
    void actualizar(Animal animal);
    void eliminar(int id);
}
