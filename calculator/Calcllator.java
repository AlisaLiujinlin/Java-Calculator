package com.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Calcllator extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root=
                FXMLLoader.load(getClass().getResource("Calculator.fxml"));
        Scene scene= new Scene(root);
        stage.setResizable(false);
        stage.setTitle("计算器");  //给计算机界面取名
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
