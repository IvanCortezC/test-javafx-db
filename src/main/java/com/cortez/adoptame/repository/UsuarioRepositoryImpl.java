package com.cortez.adoptame.repository;

import com.cortez.adoptame.dao.UsuarioDaoImpl;
import com.cortez.adoptame.dao.UsuariosDao;
import com.cortez.adoptame.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public class UsuarioRepositoryImpl implements UsuarioRepository {
    private final UsuariosDao dao;

    public UsuarioRepositoryImpl() {
        this.dao = new UsuarioDaoImpl();
    }

    @Override
    public List<Usuario> listar() throws RepositoryException {
        try {
            return this.dao.listar();
        } catch (SQLException e) {
            throw new RepositoryException("Error al listar",e);
        }
    }

    @Override
    public void crear(Usuario usuario) throws RepositoryException {
        try {
            this.dao.crear(usuario);
        } catch (SQLException e) {
            throw new RepositoryException("Error al crear",e);
        }
    }
}
