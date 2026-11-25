package com.cortez.adoptame.controller;

import com.cortez.adoptame.model.Usuario;
import com.cortez.adoptame.repository.RepositoryException;
import com.cortez.adoptame.repository.UsuarioRepository;
import com.cortez.adoptame.repository.UsuarioRepositoryImpl;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class UsuarioController {
    private final UsuarioRepository repo = new UsuarioRepositoryImpl();
    @FXML
    public TextField txtNombre;
    @FXML
    public TableView<Usuario> tablaUsuarios;
    @FXML
    public TableColumn<Usuario, Number> colId;
    @FXML
    public TableColumn<Usuario, String> colNombre;

    @FXML
    public void onCrear(MouseEvent mouseEvent) {
        Usuario u = new Usuario();
        u.setNombre(this.txtNombre.getText());

        try {
            this.repo.crear(u);
            this.listar();
        } catch (RepositoryException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void initialize() {
        this.configuracionColumnas();
        this.listar();
    }
    private void configuracionColumnas() {
        this.colId.setCellValueFactory(c -> new ReadOnlyIntegerWrapper(c.getValue().getId()));
        this.colNombre.setCellValueFactory(c -> new ReadOnlyStringWrapper(c.getValue().getNombre()));
    }
    private void listar() {
        try {
            this.tablaUsuarios.setItems(FXCollections.observableList(repo.listar()));
        } catch (RepositoryException e) {
            System.out.println(e.getMessage());
        }
    }
}
