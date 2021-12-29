package edu.bsuir.udpclient.controllers;

import java.io.IOException;

import edu.bsuir.udpclient.client.ClientUDP;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {

    private ClientUDP client = new ClientUDP();

    private String data = null;


    @FXML
    private TextField field_for_ip;

    @FXML
    private TextField field_for_port;

    @FXML
    private TextField field_for_data;

    @FXML
    private TextArea results_output;

    @FXML
    private Button connectbutton;

    @FXML
    public Button sendbutton;

    public void initialize() {

        field_for_ip.setText("localhost");
        field_for_port.setText("8080");

        connectbutton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                client.connectionCreate();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        sendbutton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                String serverWord = client.dataSendAndTake(field_for_data.getText(), "localhost", 8080);
                results_output.setText(serverWord);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}