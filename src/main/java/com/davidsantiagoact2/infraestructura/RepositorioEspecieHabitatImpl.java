package com.davidsantiagoact2.infraestructura;

import com.davidsantiagoact2.clases.EspecieHabitat;
import com.davidsantiagoact2.database.ConexionBD;
import com.davidsantiagoact2.repositorios.RepositorioEspecieHabitat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioEspecieHabitatImpl implements RepositorioEspecieHabitat {

    @Override
    public void crear(EspecieHabitat especieHabitat) {
        String sql = "INSERT INTO especie_habitat (id_especie, id_habitat) VALUES (?, ?)";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, especieHabitat.getIdEspecie());
            stmt.setInt(2, especieHabitat.getIdHabitat());
            stmt.executeUpdate();

            System.out.println("✅ Relación especie-hábitat registrada correctamente.");
        } catch (SQLException e) {
            System.err.println("❌ Error al insertar la relación: " + e.getMessage());
        }
    }

    @Override
    public List<EspecieHabitat> consultarTodos() {
        List<EspecieHabitat> lista = new ArrayList<>();
        String sql = "SELECT * FROM especie_habitat";

        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new EspecieHabitat(
                        rs.getInt("id_especie"),
                        rs.getInt("id_habitat")
                ));
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al consultar especie_habitat: " + e.getMessage());
        }

        return lista;
    }

    @Override
    public void eliminar(int idEspecie, int idHabitat) {
        String sql = "DELETE FROM especie_habitat WHERE id_especie = ? AND id_habitat = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idEspecie);
            stmt.setInt(2, idHabitat);
            stmt.executeUpdate();

            System.out.println("🗑️ Relación eliminada correctamente.");
        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar la relación: " + e.getMessage());
        }
    }
}
