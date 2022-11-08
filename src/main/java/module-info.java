module com.example.csc221_project2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.csc221_project2 to javafx.fxml;
    exports com.example.csc221_project2;
}