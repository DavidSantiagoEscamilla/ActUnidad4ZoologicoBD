package com.davidsantiagoact2;

import com.davidsantiagoact2.repositorios.RepositorioAnimal;

public class EliminarAnimalUseCase {
    private final RepositorioAnimal repositorio;

    public EliminarAnimalUseCase(RepositorioAnimal repositorio) {
        this.repositorio = repositorio;
    }

    public void ejecutar(int id) {
        repositorio.eliminar(id);
    }
}
