module com.example.weeklytasks {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.weeklytasks to javafx.fxml;
    exports com.example.weeklytasks;
}