package com.davidsantiagoact2;

public class ActualizarAnimalUseCase {
    private final RepositorioAnimal repositorio;

    public ActualizarAnimalUseCase(RepositorioAnimal repositorio) {
        this.repositorio = repositorio;
    }

    public void ejecutar(Animal animal) {
        repositorio.actualizar(animal);
    }
}
