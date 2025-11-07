package org.example.ui;

import org.example.blueprints.Constants;
import org.example.game.GameController;
import org.example.game.GameLoop;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;

public class GameView {
    public static Scene getScene(){
        // settings up canvas.
        Canvas canvas = new Canvas(Constants.GAME_WIDTH.getValue(), Constants.GAME_HEIGHT.getValue());
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);

        // game loop.
        GameController gameController = new GameController(graphicsContext);
        GameLoop gameloop = new GameLoop(gameController);
        gameloop.start();

        // pause button being escape.
        scene.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ESCAPE){
                gameloop.stop();
                SceneManager.switchSceneTo(PauseMenu.getScene(gameloop));
            }
        });
        return scene;
    }
}
