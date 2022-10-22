module com.timoshey.chatapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.timoshey.chatapplication to javafx.fxml;
    exports com.timoshey.chatapplication;
    exports com.timoshey.colourAndStyle;
    opens com.timoshey.colourAndStyle to javafx.fxml;
}