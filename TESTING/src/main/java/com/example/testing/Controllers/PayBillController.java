package com.example.testing.Controllers;

import com.example.testing.Classes.Bill;
import com.example.testing.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import static com.example.testing.HelloApplication.decfor;

public class PayBillController {

    @FXML
    private Button payBTN;

    @FXML
    private TextField payTxt;


    private HelloApplication Main = new HelloApplication();

    public void back(MouseEvent event) throws Exception {
        Main.change("ServicesView.fxml");
    }

    public void pay(MouseEvent event){
        try {
            if (payTxt.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.setContentText("You must enter the Bill amount");
                alert.showAndWait();
            } else {
                double amount = Double.parseDouble(payTxt.getText());
                if (Main.user.getAccount().payFor(new Bill(amount))) {
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
