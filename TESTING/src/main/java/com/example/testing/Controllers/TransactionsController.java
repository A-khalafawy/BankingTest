package com.example.testing.Controllers;

import com.example.testing.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class TransactionsController {

    @FXML
    private Label balanceLabel;
    @FXML
    private TableView<TableRow> table;

    @FXML
    private TableColumn<TableRow, String> amount;

    @FXML
    private TableColumn<TableRow, String> type;

    private HelloApplication mainApp = new HelloApplication();


    public void back(MouseEvent event) throws Exception {
        mainApp.change("ServicesView.fxml");
    }

    public void initialize() {
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        double balance = mainApp.user.getAccount().getBalance();
        balanceLabel.setText(String.valueOf(mainApp.decfor.format(balance))+"EGP");

        ObservableList<TableRow> data = generateRows();
        table.setItems(data);
    }

    private ObservableList<TableRow> generateRows() {
        ObservableList<TableRow> rows = FXCollections.observableArrayList();

        String [] transactionList = mainApp.user.getAccount().getStatements();

        int j = 9;
        while(j>=0){
            if(transactionList[j]!=null )
                break;
            j--;
        }

        for(int i = j; i>=0;i--){
            String type;
            if (transactionList[i].charAt(0) == 'W')
                type = "Withdraw";
            else{
                type = "Deposit";
            }
            String amount = transactionList[i].substring(1);

            TableRow row = new TableRow(amount, type);
            rows.add(row);
        }

        return rows;
    }

    public static class TableRow {
        private String amount;
        private String type;

        public TableRow(String amount, String type) {
            this.amount = amount;
            this.type = type;
        }

        public String getAmount() {
            return amount;
        }

        public String getType() {
            return type;
        }
    }
}
