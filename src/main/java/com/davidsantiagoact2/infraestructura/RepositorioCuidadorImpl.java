package com.davidsantiagoact2.infraestructura;

import com.davidsantiagoact2.clases.Cuidador;
import com.davidsantiagoact2.repositorios.RepositorioCuidador;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCuidadorImpl implements RepositorioCuidador {
    private final List<Cuidador> cuidadores = new ArrayList<>();

    @Override
    public void crear(Cuidador cuidador) {
        cuidadores.add(cuidador);
    }

    @Override
    public List<Cuidador> consultarTodos() {
        return new ArrayList<>(cuidadores);
    }

    @Override
    public Cuidador consultarPorId(int id) {
        return cuidadores.stream()
                .filter(c -> c.getIdCuidador() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void actualizar(Cuidador cuidador) {
        eliminar(cuidador.getIdCuidador());
        crear(cuidador);
    }

    @Override
    public void eliminar(int id) {
        cuidadores.removeIf(c -> c.getIdCuidador() == id);
    }
}
