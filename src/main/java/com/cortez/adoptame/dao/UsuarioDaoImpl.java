package com.cortez.adoptame.dao;

import com.cortez.adoptame.database.ConexionDB;
import com.cortez.adoptame.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImpl implements UsuariosDao {
    private static final String LISTAR = "SELECT id, nombre from usuarios ORDER BY id";
    private static final String CREAR = "INSERT INTO usuarios (nombre) VALUES (?)";

    @Override
    public List<Usuario> listar() throws SQLException {
        List<Usuario> listado = new ArrayList<>();

        try (
                Connection conn = ConexionDB.obtenerConexion();
                PreparedStatement ps = conn.prepareCall(LISTAR);
                ResultSet rs = ps.executeQuery();) {
                    while (rs.next()) {
                        listado.add(new Usuario(rs.getInt("id"), rs.getString("nombre")));
                    }
        }
        System.out.println("Listando...");
        return listado;
    }

    @Override
    public void crear(Usuario usuario) throws SQLException {
        try (
                Connection conn = ConexionDB.obtenerConexion();
                PreparedStatement ps = conn.prepareCall(CREAR);
                ) {
            ps.setString(1, usuario.getNombre());
            ps.executeUpdate();
        }
    }
}
