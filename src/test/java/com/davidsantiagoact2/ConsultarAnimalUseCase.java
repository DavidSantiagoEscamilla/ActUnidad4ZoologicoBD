package com.davidsantiagoact2;

import java.util.List;

import com.davidsantiagoact2.clases.Animal;
import com.davidsantiagoact2.repositorios.RepositorioAnimal;

public class ConsultarAnimalUseCase {
    private final RepositorioAnimal repositorio;

    public ConsultarAnimalUseCase(RepositorioAnimal repositorio) {
        this.repositorio = repositorio;
    }

    public Animal porId(int id) {
        return repositorio.consultarPorId(id);
    }

    public List<Animal> todos() {
        return repositorio.consultarTodos();
    }
}
