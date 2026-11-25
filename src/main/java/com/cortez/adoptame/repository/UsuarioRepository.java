package com.cortez.adoptame.repository;

import com.cortez.adoptame.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioRepository {
    List<Usuario> listar() throws RepositoryException;

    void crear(Usuario usuario) throws RepositoryException;
}
