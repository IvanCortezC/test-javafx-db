package com.cortez.adoptame.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/FREEPDB1";
    private static final String USER = "system";
    private static final String PASSWORD = "TuPassword123";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection conn = obtenerConexion()) {
            System.out.println("Conectado con exito");
            TablaUsuario.inicializar();
        } catch (SQLException e) {
            System.out.println("Error conectando: " + e.getMessage());
        }
    }
}
