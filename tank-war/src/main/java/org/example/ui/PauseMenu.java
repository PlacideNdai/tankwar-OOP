package org.example.ui;

import org.example.blueprints.Constants;
import org.example.game.GameLoop;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PauseMenu {
    public static Scene getScene(GameLoop gameloop){
        Button resumeBtn = new Button("Resume");
        Button menuBtn = new Button("Menu");
        Button exitBtn = new Button("Quit and Exit");

        resumeBtn.setOnAction(e -> {
            gameloop.start();
            SceneManager.switchSceneTo(GameView.getScene());
        });

        menuBtn.setOnAction(e -> {
            SceneManager.switchSceneTo(MenuView.getScene());
        });

        exitBtn.setOnAction(e -> {
            gameloop.stop();
            System.exit(0);
        });

        VBox layout = new VBox(20, resumeBtn, menuBtn, exitBtn);
        layout.setStyle("-fx-alignment: center; -fx-background-color: #222;");
        return new Scene(layout, Constants.GAME_WIDTH.getIntValue(), Constants.GAME_HEIGHT.getIntValue());
    }
}
