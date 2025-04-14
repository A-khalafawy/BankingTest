package com.example.testing.Controllers;

import com.example.testing.Classes.User;
import com.example.testing.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import static com.example.testing.HelloApplication.decfor;

public class TransferMoneyController {

    @FXML
    private TextField amountTXT;

    @FXML
    private TextField username;

    @FXML
    private Button transferBTN;

    private HelloApplication Main = new HelloApplication();

    public void back(MouseEvent event) throws Exception{
        Main.change("ServicesView.fxml");
    }

    public void transfer(MouseEvent event){
        try {
            if (amountTXT.getText().isEmpty() || username.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.setContentText("You must enter the Username and the amount to be transferred!!");
                alert.showAndWait();
            } else {
                double amount = Double.parseDouble(amountTXT.getText());
                if (username.getText().equalsIgnoreCase(Main.user.getUsername())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error!");
                    alert.setContentText("Respectfully,you Can't Transfer money to yourself.");
                    alert.showAndWait();
                } else {
                    boolean found = false;
                    User u = Main.users.get(0);
                    for (int i = 0; i < Main.users.size(); i++) {
                        u = Main.users.get(i);
                        if (username.getText().equalsIgnoreCase(u.getUsername())) {
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error!");
                        alert.setContentText("User Not Found");
                        alert.showAndWait();
                    } else if (Main.user.getAccount().transferMoney(u, amount)) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Done");
                        alert.setContentText("Money Transferred Successfully" + decfor.format(Main.user.getAccount().getBalance()));
                        alert.showAndWait();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error!");
                        alert.setContentText("Balance Not Enough! \nBalance = " + decfor.format(Main.user.getAccount().getBalance()));
                        alert.showAndWait();
                    }
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
