package com.example.testing.Controllers;

import com.example.testing.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class HelloController {
    private HelloApplication Main = new HelloApplication();

    @FXML
    void login(MouseEvent event) throws Exception{
        Main.change("loginView.fxml");
    }

    @FXML
    void register(MouseEvent event) throws Exception{
        Main.change("RegisterView.fxml");
    }
    @FXML
    void exit(MouseEvent event) {
        // Add any cleanup or exit logic here if needed.
        System.exit(0); // This will forcefully exit the Java application
    }

}
