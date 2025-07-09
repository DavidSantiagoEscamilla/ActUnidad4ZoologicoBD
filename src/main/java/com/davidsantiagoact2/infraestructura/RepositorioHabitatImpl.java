package com.davidsantiagoact2.infraestructura;

import com.davidsantiagoact2.clases.Habitat;
import com.davidsantiagoact2.database.ConexionBD;
import com.davidsantiagoact2.repositorios.RepositorioHabitat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioHabitatImpl implements RepositorioHabitat {

    @Override
    public void crear(Habitat habitat) {
        String sql = "INSERT INTO habitat (id_habitat, nombre, clima, id_zona) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, habitat.getIdHabitat());
            stmt.setString(2, habitat.getNombre());
            stmt.setString(3, habitat.getClima());
            stmt.setInt(4, habitat.getIdZona());

            stmt.executeUpdate();
            System.out.println("✅ Hábitat creado correctamente.");

        } catch (SQLException e) {
            System.err.println("❌ Error al crear hábitat: " + e.getMessage());
        }
    }

    @Override
    public List<Habitat> consultarTodos() {
        List<Habitat> lista = new ArrayList<>();
        String sql = "SELECT * FROM habitat";

        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Habitat h = new Habitat(
                    rs.getInt("id_habitat"),
                    rs.getString("nombre"),
                    rs.getString("clima"),
                    rs.getInt("id_zona")
                );
                lista.add(h);
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al consultar hábitats: " + e.getMessage());
        }

        return lista;
    }

    @Override
    public void eliminar(int idHabitat) {
        String sql = "DELETE FROM habitat WHERE id_habitat = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idHabitat);
            stmt.executeUpdate();
            System.out.println("🗑️ Hábitat eliminado correctamente.");

        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar hábitat: " + e.getMessage());
        }
    }
}
