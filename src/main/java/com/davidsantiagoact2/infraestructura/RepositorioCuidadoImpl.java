package com.davidsantiagoact2.infraestructura;

import com.davidsantiagoact2.clases.Cuidado;
import com.davidsantiagoact2.database.ConexionBD;
import com.davidsantiagoact2.repositorios.RepositorioCuidado;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepositorioCuidadoImpl implements RepositorioCuidado {

    @Override
    public void crear(Cuidado cuidado) {
        String sql = "INSERT INTO cuidado (id_personal, id_animal, fecha) VALUES (?, ?, ?)";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cuidado.getIdPersonal());
            stmt.setInt(2, cuidado.getIdAnimal());
            stmt.setDate(3, Date.valueOf(cuidado.getFecha()));
            stmt.executeUpdate();

            System.out.println("✅ Cuidado registrado correctamente.");

        } catch (SQLException e) {
            System.err.println("❌ Error al registrar cuidado: " + e.getMessage());
        }
    }

    @Override
    public List<Cuidado> consultarTodos() {
        List<Cuidado> lista = new ArrayList<>();
        String sql = "SELECT * FROM cuidado";

        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cuidado cuidado = new Cuidado(
                        rs.getInt("id_personal"),
                        rs.getInt("id_animal"),
                        rs.getDate("fecha").toLocalDate()
                );
                lista.add(cuidado);
            }

        } catch (SQLException e) {
            System.err.println("❌ Error al consultar cuidados: " + e.getMessage());
        }

        return lista;
    }

    @Override
    public void eliminar(int idPersonal, int idAnimal) {
        String sql = "DELETE FROM cuidado WHERE id_personal = ? AND id_animal = ?";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPersonal);
            stmt.setInt(2, idAnimal);
            stmt.executeUpdate();

            System.out.println("🗑️ Cuidado eliminado correctamente.");

        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar cuidado: " + e.getMessage());
        }
    }
}
