package com.davidsantiagoact2;

import com.davidsantiagoact2.clases.Animal;
import com.davidsantiagoact2.repositorios.RepositorioAnimal;

public class CrearAnimalUseCase {
    private final RepositorioAnimal repositorio;

    public CrearAnimalUseCase(RepositorioAnimal repositorio) {
        this.repositorio = repositorio;
    }

    public void ejecutar(Animal animal) {
        repositorio.crear(animal);
    }
}
