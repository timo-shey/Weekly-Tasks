module com.example.tcpchatroom {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tcpchatroom to javafx.fxml;
    exports com.example.tcpchatroom;
}