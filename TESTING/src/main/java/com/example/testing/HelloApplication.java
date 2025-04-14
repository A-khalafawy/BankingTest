package com.example.testing;

import com.example.testing.Classes.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class HelloApplication extends Application {
    public static DecimalFormat decfor = new DecimalFormat("0.00");
    private static Stage stg;
    public static User user;
    public static ArrayList <User> users=new ArrayList(Arrays.asList(new User("Abdallah","Elkhalafawy","ak","01500000000",1500,"0202020","11145678912345"),
            new User("Omar","Abusamra","oa","010000000",1500,"1234","22225678912345")));

    public HelloApplication(){
        decfor.setRoundingMode(RoundingMode.DOWN);
    }

    @Override
    public void start(Stage stage) throws IOException {
        stg=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600,400);
        stage.setTitle("Payzz");
        stage.setScene(scene);
        stage.show();
    }

    public void change(String fxml) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }



    public static void main(String[] args) {
        launch();
    }
}