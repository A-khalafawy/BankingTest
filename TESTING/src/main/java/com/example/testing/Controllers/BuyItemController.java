package com.example.testing.Controllers;

import com.example.testing.Classes.Item;
import com.example.testing.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import static com.example.testing.HelloApplication.decfor;

public class BuyItemController {

    @FXML
    private Button buyBTN;

    @FXML
    private TextField itemTxt;

    @FXML
    private TextField priceTxt;

    private HelloApplication Main = new HelloApplication();

    public void back(MouseEvent event) throws Exception{
        Main.change("ServicesView.fxml");
    }

    public void pay(MouseEvent event) throws Exception {
        try {
            if (itemTxt.getText().isEmpty() || priceTxt.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.setContentText("You must enter item's name and the Bill amount");
                alert.showAndWait();
            } else {
                double amount = Double.parseDouble(priceTxt.getText());
                if (Main.user.getAccount().payFor(new Item(amount))) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Done");
                    alert.setContentText("Bill Payed Successfully" + decfor.format(Main.user.getAccount().getBalance()));
                    alert.showAndWait();
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error!");
                    alert.setContentText("Balance Not Enough! \nBalance = "+decfor.format(Main.user.getAccount().getBalance()));
                    alert.showAndWait();
                }
            }
        } catch (NumberFormatException nfe) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setContentText("You must enter a number");
            alert.showAndWait();
        }
    }
}

