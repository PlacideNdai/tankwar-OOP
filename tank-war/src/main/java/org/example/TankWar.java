package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TankWar extends Application {

    @Override
    public void start(Stage stage){
        Label intro = new Label("Hello friends!");
        Scene scene = new Scene(intro, 300, 300);
        stage.setScene(scene);

        stage.setTitle("Tank War");
        stage.show();
    }

    public static  void main(String[] args){
        launch();
    }
}