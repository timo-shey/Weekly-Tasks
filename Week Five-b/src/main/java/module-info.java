module com.example.chatapplicationmultipleclients {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chatapplicationmultipleclients to javafx.fxml;
    exports com.example.chatapplicationmultipleclients;
}