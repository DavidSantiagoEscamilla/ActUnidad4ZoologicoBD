package com.davidsantiagoact2.repositorios;

import com.davidsantiagoact2.clases.Animal;
import java.util.List;

public interface RepositorioAnimal {
    void crear(Animal animal);
    List<Animal> consultarTodos();
    Animal consultarPorId(int id);
    void actualizar(Animal animal);
    void eliminar(int id);
}
