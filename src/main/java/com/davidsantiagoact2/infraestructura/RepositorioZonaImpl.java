package com.davidsantiagoact2.infraestructura;

import com.davidsantiagoact2.clases.Zona;
import com.davidsantiagoact2.database.ConexionBD;
import com.davidsantiagoact2.repositorios.RepositorioZona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioZonaImpl implements RepositorioZona {

    @Override
    public void crear(Zona zona) {
        String sql = "INSERT INTO zona (id_zona, nombre) VALUES (?, ?)";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, zona.getIdZona());
            stmt.setString(2, zona.getNombre());
            stmt.executeUpdate();

            System.out.println("✅ Zona registrada correctamente.");

        } catch (SQLException e) {
            System.err.println("❌ Error al registrar zona: " + e.getMessage());
        }
    }

    @Override
    public List<Zona> consultarTodos() {
        List<Zona> lista = new ArrayList<>();
        String sql = "SELECT * FROM zona";

        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Zona zona = new Zona(
                        rs.getInt("id_zona"),
                        rs.getString("nombre")
                );
                lista.add(zona);
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al consultar zonas: " + e.getMessage());
        }

        return lista;
    }

    @Override
    public void eliminar(int idZona) {
        String sql = "DELETE FROM zona WHERE id_zona = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idZona);
            stmt.executeUpdate();

            System.out.println("🗑️ Zona eliminada correctamente.");

        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar zona: " + e.getMessage());
        }
    }
}
