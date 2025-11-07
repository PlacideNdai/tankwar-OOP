package org.example.game;

import java.util.ArrayList;
import java.util.List;

import org.example.blueprints.Constants;
import org.example.blueprints.GameObject;
import org.example.entities.Tank;
import org.example.input.InputHandler;

import javafx.scene.canvas.GraphicsContext;

public class GameController {
    private GraphicsContext graphicsContext;
    private final List<GameObject> objectsInGame = new ArrayList<>();
    private InputHandler inputHandler;
    private Tank player;

    public GameController(GraphicsContext context) {
        this.graphicsContext = context;
        this.player = new Tank(100, 100);
        this.addObject(this.player);
    }

    public void update(double deltaTime) {

        if (inputHandler != null) {
            if (inputHandler.isUp()) {
                this.player.move(0, -Constants.NORMAL_SPEED.getValue() * deltaTime);
                this.player.rotate(0);
            }
            if (inputHandler.isDown()) {
                this.player.move(0, Constants.NORMAL_SPEED.getValue() * deltaTime);
                this.player.rotate(180);
            }
            if (inputHandler.isLeft()) {
                this.player.move(-Constants.NORMAL_SPEED.getValue() * deltaTime, 0);
                this.player.rotate(90);
            }
            if (inputHandler.isRight()) {
                this.player.move(Constants.NORMAL_SPEED.getValue() * deltaTime, 0);
                this.player.rotate(270);
            }
        }

        for (GameObject obj : objectsInGame) {
            obj.update(deltaTime);
        }
    }

    // ----------------------------------------------
    // Input: handles for the player.
    // ----------------------------------------------
    public void setInput(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void render() {
        graphicsContext.clearRect(0, 0, Constants.GAME_WIDTH.getValue(), Constants.GAME_HEIGHT.getValue());

        for (GameObject obj : objectsInGame) {
            obj.render(graphicsContext);
        }
    }

    public void addObject(GameObject obj) {
        objectsInGame.add(obj);
    }
}
