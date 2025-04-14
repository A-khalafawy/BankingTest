package com.example.testing.Controllers;


import com.example.testing.Classes.User;
import com.example.testing.Exceptions.Ex;
import com.example.testing.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class loginViewController {
    @FXML
    private TextField tUsername;
    @FXML
    private PasswordField tPassword;

    @FXML
    private Button Loginbtn2;

    @FXML
    private Button backbtn;

    private HelloApplication Main = new HelloApplication();

    public void back(MouseEvent event) throws Exception{
        Main.change("hello-view.fxml");
    }

    public void submit(MouseEvent event){
        try{
            boolean found = true;
            if(tUsername.getText().isEmpty()||tPassword.getText().isEmpty())
                throw new Ex("You have to fill both Username and Password");

            for(int i = 0;i<Main.users.size();i++) {
                User u = Main.users.get(i);
                if(tUsername.getText().equalsIgnoreCase(u.getUsername())&&tPassword.getText().equals(u.getPassword())){
                    Main.change("ServicesView.fxml");
                    Main.user = u;
                    return;
                }
            }
            throw new Ex("Wrong Username or Password!!");
        }
        catch(Ex ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!!");
            alert.setContentText(ex.getMessage());

            alert.showAndWait();
        }
        catch(Exception ex){}
   }
}
