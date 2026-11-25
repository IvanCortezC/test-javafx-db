package com.cortez.adoptame;

import com.cortez.adoptame.database.TablaUsuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class MantenedorApplication extends Application {

    @Override
    public void init() throws SQLException {
        TablaUsuario.inicializar();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MantenedorApplication.class.getResource("usuario-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Mantenedor de usuarios");
        stage.setScene(scene);
        stage.show();
    }
}
