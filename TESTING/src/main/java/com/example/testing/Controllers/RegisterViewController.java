package com.example.testing.Controllers;

import com.example.testing.Classes.User;
import com.example.testing.Exceptions.Ex;
import com.example.testing.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class RegisterViewController {

    @FXML
    private Button Back;

    @FXML
    private Button Register;

    @FXML
    private TextField fName;

    @FXML
    private TextField lName;

    @FXML
    private TextField nationalId;

    @FXML
    private PasswordField TxtP;

    @FXML
    private PasswordField Txtcp;

    @FXML
    private TextField Txtpn;

    @FXML
    private TextField username;

    private HelloApplication Main = new HelloApplication();

    public void back(MouseEvent event) throws Exception{
        Main.change("hello-view.fxml");
    }

    public void submit(MouseEvent event) throws Exception{
        try{
            if(username.getText().isEmpty()
                    || nationalId.getText().isEmpty()
                    || fName.getText().isEmpty()
                    || TxtP.getText().isEmpty()
                    || Txtcp.getText().isEmpty()
                    || Txtpn.getText().isEmpty()
                    || lName.getText().isEmpty())
                throw new Ex("You have to complete the form!");

            if(!TxtP.getText().equals(Txtcp.getText()))
                throw new Ex("Password and Confirm password doesn't match\nRewrite you password");

            for(int i = 0;i<Main.users.size();i++) {
                if(username.getText().equalsIgnoreCase(Main.users.get(i).getUsername())){
                    throw new Ex("Username already exists\nEnter another one");
                }
                if(nationalId.getText().equalsIgnoreCase(Main.users.get(i).getNationalId())){
                    throw new Ex("National ID already exists\nYou already have an account");
                }
            }
            User newUser = new User(fName.getText(),lName.getText(),username.getText(),Txtpn.getText(),TxtP.getText(),nationalId.getText());
            Main.users.add(newUser);
            Main.change("loginView.fxml");

        }catch(Ex ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!!");
            alert.setContentText(ex.getMessage());

            alert.showAndWait();
        }catch(Exception ex){

        }
    }
}
