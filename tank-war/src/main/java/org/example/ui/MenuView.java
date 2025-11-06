package org.example.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MenuView {
    public static Scene getScene(){
        Button playBtn = new Button("Play");
        Button exitBtn = new Button("Quit and Exit");

        playBtn.setOnAction(e -> SceneManager.switchSceneTo(GameView.getScene()));
        exitBtn.setOnAction(e -> System.exit(0));

        VBox layout = new VBox(20, playBtn, exitBtn);
        layout.setStyle("-fx-alignment: center; -fx-background-color: #222;");
        return new Scene(layout, 800, 600);
    }
}
