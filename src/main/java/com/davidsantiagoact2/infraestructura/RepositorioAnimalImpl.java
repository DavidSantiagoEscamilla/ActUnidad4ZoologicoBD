package com.davidsantiagoact2.infraestructura;

import com.davidsantiagoact2.clases.Animal;
import com.davidsantiagoact2.database.ConexionBD;
import com.davidsantiagoact2.repositorios.RepositorioAnimal;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepositorioAnimalImpl implements RepositorioAnimal {

    @Override
    public void crear(Animal animal) {
        String sql = "INSERT INTO animal (id_animal, nombre, fecha_nacimiento, sexo, id_especie, id_habitat, id_personal) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, animal.getIdAnimal());
            stmt.setString(2, animal.getNombre());
            stmt.setDate(3, Date.valueOf(animal.getFechaNacimiento()));
            stmt.setString(4, animal.getSexo());
            stmt.setInt(5, animal.getIdEspecie());
            stmt.setInt(6, animal.getIdHabitat());
            stmt.setInt(7, animal.getIdPersonal());

            stmt.executeUpdate();
            System.out.println("✅ Animal guardado correctamente.");

        } catch (SQLException e) {
            System.err.println("❌ Error al guardar el animal: " + e.getMessage());
        }
    }

    @Override
    public List<Animal> consultarTodos() {
        List<Animal> animales = new ArrayList<>();
        String sql = "SELECT * FROM animal";

        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Animal animal = new Animal(
                    rs.getInt("id_animal"),
                    rs.getString("nombre"),
                    rs.getDate("fecha_nacimiento").toLocalDate(),
                    rs.getString("sexo"),
                    rs.getInt("id_especie"),
                    rs.getInt("id_habitat"),
                    rs.getInt("id_personal")
                );
                animales.add(animal);
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al consultar animales: " + e.getMessage());
        }

        return animales;
    }

    @Override
    public Animal consultarPorId(int id) {
        String sql = "SELECT * FROM animal WHERE id_animal = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Animal(
                    rs.getInt("id_animal"),
                    rs.getString("nombre"),
                    rs.getDate("fecha_nacimiento").toLocalDate(),
                    rs.getString("sexo"),
                    rs.getInt("id_especie"),
                    rs.getInt("id_habitat"),
                    rs.getInt("id_personal")
                );
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al consultar por ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void actualizar(Animal animal) {
        String sql = "UPDATE animal SET nombre=?, fecha_nacimiento=?, sexo=?, id_especie=?, id_habitat=?, id_personal=? WHERE id_animal=?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, animal.getNombre());
            stmt.setDate(2, Date.valueOf(animal.getFechaNacimiento()));
            stmt.setString(3, animal.getSexo());
            stmt.setInt(4, animal.getIdEspecie());
            stmt.setInt(5, animal.getIdHabitat());
            stmt.setInt(6, animal.getIdPersonal());
            stmt.setInt(7, animal.getIdAnimal());

            stmt.executeUpdate();
            System.out.println("✏️ Animal actualizado correctamente.");

        } catch (SQLException e) {
            System.err.println("❌ Error al actualizar el animal: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM animal WHERE id_animal = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("🗑️ Animal eliminado correctamente.");

        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar el animal: " + e.getMessage());
        }
    }
}
