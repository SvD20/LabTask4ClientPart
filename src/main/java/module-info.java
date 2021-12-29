module edu.bsuir.udpclient {
    requires javafx.controls;
    requires javafx.fxml;

    exports edu.bsuir.udpclient.app;
    opens edu.bsuir.udpclient.app to javafx.fxml;
    exports edu.bsuir.udpclient.client;
    opens edu.bsuir.udpclient.client to javafx.fxml;
    exports edu.bsuir.udpclient.controllers;
    opens edu.bsuir.udpclient.controllers to javafx.fxml;
}
