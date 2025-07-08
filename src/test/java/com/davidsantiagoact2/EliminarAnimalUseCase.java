package com.davidsantiagoact2;

public class EliminarAnimalUseCase {
    private final RepositorioAnimal repositorio;

    public EliminarAnimalUseCase(RepositorioAnimal repositorio) {
        this.repositorio = repositorio;
    }

    public void ejecutar(int id) {
        repositorio.eliminar(id);
    }
}
