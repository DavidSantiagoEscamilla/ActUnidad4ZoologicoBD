package com.davidsantiagoact2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/bd_tmp_david_escamilla_v2";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "12345";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }
}
