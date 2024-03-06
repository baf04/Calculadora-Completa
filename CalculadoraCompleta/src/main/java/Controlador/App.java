package Controlador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;



public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("/Vista/calc.fxml"));
        Pane rootPane = (Pane) loader.load();

        Scene scene = new Scene(rootPane, 600, 500);
        stage.setResizable(true);
        stage.setMinWidth(500.0);
        stage.setMinHeight(600.0);
        stage.setMaxWidth(1000.0);
        stage.setMaxHeight(650.0);
        stage.setTitle("Calculadora");
        stage.setResizable(true);



        stage.setScene(scene);
        stage.show();
    }


}