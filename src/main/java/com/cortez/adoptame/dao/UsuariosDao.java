package com.cortez.adoptame.dao;

import com.cortez.adoptame.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface UsuariosDao {
    List<Usuario> listar() throws SQLException;

    void crear(Usuario usuario) throws SQLException;

}
