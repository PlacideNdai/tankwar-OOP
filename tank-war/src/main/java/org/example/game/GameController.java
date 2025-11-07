package org.example.game;

import java.util.ArrayList;
import java.util.List;

import org.example.blueprints.Constants;
import org.example.blueprints.GameObject;
import org.example.entities.Tank;
import org.example.entities.Wall;
import org.example.input.InputHandler;
import org.example.ui.HUD;

import javafx.scene.canvas.GraphicsContext;

public class GameController {
    private GraphicsContext graphicsContext;
    private final List<GameObject> objectsInGame = new ArrayList<>();
    private InputHandler inputHandler;
    private Tank player;
    private HUD hud;

    public GameController(GraphicsContext context) {
        this.graphicsContext = context;
        this.player = new Tank(100, 100);
        this.hud = new HUD(this.player);
        this.addObject(this.player);

        // ----------------------------------------------
        // tesing walls. DELETE AFTER TESTING.
        // ----------------------------------------------
        addObject(new Wall(400, 200));
        addObject(new Wall(200, 400));
        addObject(new Wall(400, 400));
        addObject(new Wall(100, 100));
    }

    public void update(double deltaTime) {

        if (inputHandler != null) {
            if (inputHandler.isUp()) {
                this.player.move(0, -Constants.NORMAL_SPEED.getIntValue() * deltaTime);
                this.player.rotate(Constants.NORTH.getStringValue());
            }
            if (inputHandler.isDown()) {
                this.player.move(0, Constants.NORMAL_SPEED.getIntValue() * deltaTime);
                this.player.rotate(Constants.SOUTH.getStringValue());
            }
            if (inputHandler.isLeft()) {
                this.player.move(-Constants.NORMAL_SPEED.getIntValue() * deltaTime, 0);
                this.player.rotate(Constants.WEST.getStringValue());
            }
            if (inputHandler.isRight()) {
                this.player.move(Constants.NORMAL_SPEED.getIntValue() * deltaTime, 0);
                this.player.rotate(Constants.EAST.getStringValue());
            }
        }

        // check for collisions.
        checkCollisions();

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
        graphicsContext.clearRect(0, 0, Constants.GAME_WIDTH.getIntValue(), Constants.GAME_HEIGHT.getIntValue());

        for (GameObject obj : objectsInGame) {
            obj.render(graphicsContext);
        }

        // render HUD.
        hud.render(graphicsContext);
    }

    public void addObject(GameObject obj) {
        objectsInGame.add(obj);
    }

    // ----------------------------------------------
    // Collision detection.
    // ----------------------------------------------

    public void checkCollisions() {
        for (GameObject obj : objectsInGame) {
            if (obj instanceof Wall wall) {
                if (player.collidesWith(wall)) {
                    System.out.println("Collision detected!");
                    player.undoMove();
                }
            }
        }
    }
}
