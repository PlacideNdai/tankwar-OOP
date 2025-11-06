package org.example;

import org.example.ui.MenuView;
import org.example.ui.SceneManager;

import javafx.application.Application;
import javafx.stage.Stage;

public class TankWar extends Application {

    @Override
    public void start(Stage stage){
        SceneManager.init(stage);
        SceneManager.switchSceneTo(MenuView.getScene());
    }

    public static  void main(String[] args){
        launch();
    }
}