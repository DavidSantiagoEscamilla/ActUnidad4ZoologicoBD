package com.davidsantiagoact2.repositorios;

import com.davidsantiagoact2.Animal;
import com.davidsantiagoact2.repositorios.RepositorioAnimal;

import java.util.ArrayList;
import java.util.List;

public class RepositorioAnimalImpl implements RepositorioAnimal {
    private final List<Animal> animales = new ArrayList<>();

    @Override
    public void crear(Animal animal) {
        animales.add(animal);
    }

    @Override
    public Animal consultarPorId(int id) {
        return animales.stream()
                       .filter(a -> a.getIdAnimal() == id)
                       .findFirst()
                       .orElse(null);
    }

    @Override
    public List<Animal> consultarTodos() {
        return new ArrayList<>(animales);
    }

    @Override
    public void actualizar(Animal animal) {
        eliminar(animal.getIdAnimal());
        crear(animal);
    }

    @Override
    public void eliminar(int id) {
        animales.removeIf(a -> a.getIdAnimal() == id);
    }
}