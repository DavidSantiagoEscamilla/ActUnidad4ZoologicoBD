package com.davidsantiagoact2;

import com.davidsantiagoact2.clases.Animal;
import com.davidsantiagoact2.repositorios.RepositorioAnimal;

public class ActualizarAnimalUseCase {
    private final RepositorioAnimal repositorio;

    public ActualizarAnimalUseCase(RepositorioAnimal repositorio) {
        this.repositorio = repositorio;
    }

    public void ejecutar(Animal animal) {
        repositorio.actualizar(animal);
    }
}
