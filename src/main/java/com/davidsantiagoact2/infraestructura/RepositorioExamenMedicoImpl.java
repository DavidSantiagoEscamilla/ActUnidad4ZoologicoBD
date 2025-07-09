package com.davidsantiagoact2.infraestructura;

import com.davidsantiagoact2.clases.ExamenMedico;
import com.davidsantiagoact2.database.ConexionBD;
import com.davidsantiagoact2.repositorios.RepositorioExamenMedico;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepositorioExamenMedicoImpl implements RepositorioExamenMedico {

    @Override
    public void crear(ExamenMedico examen) {
        String sql = "INSERT INTO examenmedico (id_examen, tipo_examen, resultado, id_animal, fecha) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, examen.getIdExamen());
            stmt.setString(2, examen.getTipoExamen());
            stmt.setString(3, examen.getResultado());
            stmt.setInt(4, examen.getIdAnimal());
            stmt.setDate(5, Date.valueOf(examen.getFecha()));

            stmt.executeUpdate();
            System.out.println("✅ Examen médico guardado correctamente.");
        } catch (SQLException e) {
            System.err.println("❌ Error al guardar: " + e.getMessage());
        }
    }

    @Override
    public List<ExamenMedico> consultarTodos() {
        List<ExamenMedico> lista = new ArrayList<>();
        String sql = "SELECT * FROM examenmedico";

        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ExamenMedico examen = new ExamenMedico(
                    rs.getInt("id_examen"),
                    rs.getString("tipo_examen"),
                    rs.getString("resultado"),
                    rs.getInt("id_animal"),
                    rs.getDate("fecha").toLocalDate()
                );
                lista.add(examen);
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al consultar: " + e.getMessage());
        }

        return lista;
    }

    @Override
    public ExamenMedico consultarPorId(int id) {
        String sql = "SELECT * FROM examenmedico WHERE id_examen = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new ExamenMedico(
                    rs.getInt("id_examen"),
                    rs.getString("tipo_examen"),
                    rs.getString("resultado"),
                    rs.getInt("id_animal"),
                    rs.getDate("fecha").toLocalDate()
                );
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al buscar por ID: " + e.getMessage());
        }

        return null;
    }

    @Override
    public void actualizar(ExamenMedico examen) {
        String sql = "UPDATE examenmedico SET tipo_examen=?, resultado=?, id_animal=?, fecha=? WHERE id_examen=?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, examen.getTipoExamen());
            stmt.setString(2, examen.getResultado());
            stmt.setInt(3, examen.getIdAnimal());
            stmt.setDate(4, Date.valueOf(examen.getFecha()));
            stmt.setInt(5, examen.getIdExamen());

            stmt.executeUpdate();
            System.out.println("✏️ Examen médico actualizado.");
        } catch (SQLException e) {
            System.err.println("❌ Error al actualizar: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM examenmedico WHERE id_examen=?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("🗑️ Examen médico eliminado.");
        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar: " + e.getMessage());
        }
    }
}
