module com.cortez.adoptame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.cortez.adoptame to javafx.fxml;
    exports com.cortez.adoptame;
    exports com.cortez.adoptame.controller;
    opens com.cortez.adoptame.controller to javafx.fxml;
}