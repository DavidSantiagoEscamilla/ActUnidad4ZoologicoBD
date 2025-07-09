package com.davidsantiagoact2.infraestructura;

import com.davidsantiagoact2.clases.Itinerario;
import com.davidsantiagoact2.database.ConexionBD;
import com.davidsantiagoact2.repositorios.RepositorioItinerario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioItinerarioImpl implements RepositorioItinerario {

    @Override
    public void crear(Itinerario itinerario) {
        String sql = "INSERT INTO itinerario (id_itinerario, nombre, descripcion, duracion_minutos, id_guia) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, itinerario.getIdItinerario());
            stmt.setString(2, itinerario.getNombre());
            stmt.setString(3, itinerario.getDescripcion());
            stmt.setInt(4, itinerario.getDuracionMinutos());
            stmt.setInt(5, itinerario.getIdGuia());

            stmt.executeUpdate();
            System.out.println("✅ Itinerario guardado correctamente.");

        } catch (SQLException e) {
            System.err.println("❌ Error al crear itinerario: " + e.getMessage());
        }
    }

    @Override
    public List<Itinerario> consultarTodos() {
        List<Itinerario> lista = new ArrayList<>();
        String sql = "SELECT * FROM itinerario";

        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Itinerario i = new Itinerario(
                    rs.getInt("id_itinerario"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getInt("duracion_minutos"),
                    rs.getInt("id_guia")
                );
                lista.add(i);
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al consultar itinerarios: " + e.getMessage());
        }

        return lista;
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM itinerario WHERE id_itinerario = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("🗑️ Itinerario eliminado correctamente.");

        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar itinerario: " + e.getMessage());
        }
    }
}
