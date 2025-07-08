package com.davidsantiagoact2;

public class CrearAnimalUseCase {
    private final RepositorioAnimal repositorio;

    public CrearAnimalUseCase(RepositorioAnimal repositorio) {
        this.repositorio = repositorio;
    }

    public void ejecutar(Animal animal) {
        repositorio.crear(animal);
    }
}
