module com.example.practica7 {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;
    requires org.json;


    opens Controlador to javafx.fxml;
    exports Controlador;
}