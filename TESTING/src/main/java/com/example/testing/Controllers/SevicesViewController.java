package com.example.testing.Controllers;

import com.example.testing.HelloApplication;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class SevicesViewController {


    @FXML
    private Button BuyItem;

    @FXML
    private Button PayBill;

    @FXML
    private Button Transactions;

    @FXML
    private Button TransferMoney;

    @FXML
    private Button backbutton;

    private HelloApplication Main = new HelloApplication();

    public void back(MouseEvent event) throws Exception{
        Main.user = null;
        Main.change("hello-view.fxml");
    }

    public void payBill(MouseEvent event) throws Exception{
        Main.change("PayBill.fxml");
    }

    public void buyItem(MouseEvent event) throws Exception{
        Main.change("buyItem.fxml");
    }

    public void transferMoney(MouseEvent event) throws Exception{
        Main.change("TransferMoney.fxml");
    }

    public void transactions(MouseEvent event) throws Exception{
        Main.change("Transactions.fxml");
    }



}
