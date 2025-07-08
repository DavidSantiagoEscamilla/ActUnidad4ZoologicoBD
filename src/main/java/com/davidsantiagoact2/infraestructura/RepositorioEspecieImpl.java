package com.davidsantiagoact2.infraestructura;

import com.davidsantiagoact2.clases.Especie;
import com.davidsantiagoact2.database.ConexionBD;
import com.davidsantiagoact2.repositorios.RepositorioEspecie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositorioEspecieImpl implements RepositorioEspecie {

    @Override
    public void crear(Especie especie) {
        String sql = "INSERT INTO especie (id_especie, nombre_cientifico, nombre_comun, tipo) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, especie.getIdEspecie());
            stmt.setString(2, especie.getNombreCientifico());
            stmt.setString(3, especie.getNombreComun());
            stmt.setString(4, especie.getTipo());

            stmt.executeUpdate();
            System.out.println("✅ Especie guardada correctamente.");

        } catch (SQLException e) {
            System.err.println("❌ Error al guardar la especie: " + e.getMessage());
        }
    }

    @Override
    public List<Especie> consultarTodos() {
        List<Especie> especies = new ArrayList<>();
        String sql = "SELECT * FROM especie";

        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Especie especie = new Especie(
                    rs.getInt("id_especie"),
                    rs.getString("nombre_cientifico"),
                    rs.getString("nombre_comun"),
                    rs.getString("tipo")
                );
                especies.add(especie);
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al consultar especies: " + e.getMessage());
        }

        return especies;
    }

    @Override
    public Especie consultarPorId(int id) {
        String sql = "SELECT * FROM especie WHERE id_especie = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Especie(
                    rs.getInt("id_especie"),
                    rs.getString("nombre_cientifico"),
                    rs.getString("nombre_comun"),
                    rs.getString("tipo")
                );
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al consultar especie por ID: " + e.getMessage());
        }

        return null;
    }

    @Override
    public void actualizar(Especie especie) {
        String sql = "UPDATE especie SET nombre_cientifico = ?, nombre_comun = ?, tipo = ? WHERE id_especie = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, especie.getNombreCientifico());
            stmt.setString(2, especie.getNombreComun());
            stmt.setString(3, especie.getTipo());
            stmt.setInt(4, especie.getIdEspecie());

            stmt.executeUpdate();
            System.out.println("✏️ Especie actualizada correctamente.");

        } catch (SQLException e) {
            System.err.println("❌ Error al actualizar la especie: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM especie WHERE id_especie = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("🗑️ Especie eliminada correctamente.");

        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar la especie: " + e.getMessage());
        }
    }
}
