package com.davidsantiagoact2.infraestructura;

import com.davidsantiagoact2.clases.Especie;
import com.davidsantiagoact2.repositorios.RepositorioEspecie;

import java.util.ArrayList;
import java.util.List;

public class RepositorioEspecieImpl implements RepositorioEspecie {
    private final List<Especie> especies = new ArrayList<>();

    @Override
    public void crear(Especie especie) {
        especies.add(especie);
    }

    @Override
    public List<Especie> obtenerTodas() {
        return especies;
    }

    @Override
    public Especie buscarPorId(int id) {
        return especies.stream()
                .filter(e -> e.getIdEspecie() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void actualizar(Especie especie) {
        Especie existente = buscarPorId(especie.getIdEspecie());
        if (existente != null) {
            existente.setNombreComun(especie.getNombreComun());
            existente.setNombreCientifico(especie.getNombreCientifico());
        }
    }

    @Override
    public void eliminar(int id) {
        Especie especie = buscarPorId(id);
        if (especie != null) {
            especies.remove(especie);
        }
    }
}
