package org.example.game;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.example.blueprints.Constants;
import org.example.blueprints.Createfactory;
import org.example.blueprints.GameObject;
import org.example.entities.AutoTank;
import org.example.entities.Heals;
import org.example.entities.Tank;
import org.example.input.InputHandler;
import org.example.ui.HUD;

import javafx.scene.canvas.GraphicsContext;

public class GameController {
    private GraphicsContext graphicsContext;
    private final List<GameObject> objectsInGame = new ArrayList<>();
    private InputHandler inputHandler;
    private Tank player;
    private HUD hud;
    private double shootingCooldown = 0;
    private long numberOfAutoTanks = 0;
    private long numberOfhelps = 0;

    public GameController(GraphicsContext context) {
        this.graphicsContext = context;
        this.player = new Tank(500, 500);
        this.addObject(this.player);

        // ----------------------------------------------
        // tesing walls. DELETE AFTER TESTING.
        // ----------------------------------------------
        spawn(new WallFactory(200, 200));
        spawn(new WallFactory(250, 200));
        spawn(new WallFactory(300, 200));
        spawn(new WallFactory(350, 200));
        spawn(new WallFactory(400, 200));

        spawn(new WallFactory(400, 400));
        spawn(new WallFactory(400, 450));
        spawn(new WallFactory(400, 500));

        // spawning auto tanks and heals.
        for (int a = 0; a < 10; a++) {
            spawn(new TankFactory());
            numberOfAutoTanks++;
        }

        for (int a = 0; a < 10; a++) {
            addObject(new Heals());
            numberOfhelps++;
        }
    }

    public void update(double deltaTime) {

        if (inputHandler != null) {
            double speed = Constants.NORMAL_SPEED.getIntValue() * deltaTime;

            // Handle X-axis movement
            if (inputHandler.isLeft()) {
                this.player.move(-speed, 0);
                this.player.rotate(Constants.WEST.getStringValue());
            } else if (inputHandler.isRight()) {
                this.player.move(speed, 0);
                this.player.rotate(Constants.EAST.getStringValue());
            }
            handleCollisions();

            // Handle Y-axis movement
            if (inputHandler.isUp()) {
                this.player.move(0, -speed);
                this.player.rotate(Constants.NORTH.getStringValue());
            } else if (inputHandler.isDown()) {
                this.player.move(0, speed);
                this.player.rotate(Constants.SOUTH.getStringValue());
            }
            handleCollisions();

            // ----------------------------------------------
            // shooting.
            // ----------------------------------------------
            shootingCooldown -= deltaTime;
            if (inputHandler.isShoot() && shootingCooldown <= 0) {
                addObject(this.player.shoot());
                shootingCooldown = 0.2;
            }
        }

        // ----------------------------------------------
        // update objects.
        // ----------------------------------------------
        List<GameObject> newObjects = new ArrayList<>();
        for (GameObject obj : objectsInGame) {
            if (obj instanceof AutoTank auto) {
                if (auto.readyToShoot(deltaTime)) {
                    // temp store.
                    newObjects.add(auto.shoot());
                }
            }
        }

        // ----------------------------------------------
        // adding when its ready.
        // ----------------------------------------------
        objectsInGame.addAll(newObjects);

        // ----------------------------------------------
        // updating objects.
        // ----------------------------------------------
        for (GameObject obj : objectsInGame) {
            if (obj.isAlive()) {
                obj.update(deltaTime);
            }
        }

        // ----------------------------------------------
        // collisions.
        // ----------------------------------------------
        handleCollisions();

        // ----------------------------------------------
        // handle respawn.
        // ----------------------------------------------
        numberOfAutoTanks = objectsInGame.stream().filter(ob -> ob instanceof AutoTank).count();
        numberOfhelps = objectsInGame.stream().filter(ob -> ob instanceof Heals).count();

        if (numberOfAutoTanks < 10) {
            spawn(new TankFactory());
        }

        if (numberOfhelps < 10) {
            addObject(new Heals());
        }
    }

    private void handleCollisions() {
        for (GameObject objA : objectsInGame) {
            for (GameObject objB : objectsInGame) {
                if (objA == objB)
                    continue;

                if (objA.collidesWith(objB)) {
                    objA.onCollide(objB);
                    objB.onCollide(objA);
                }
            }
        }

        objectsInGame.removeIf(Predicate.not(GameObject::isAlive));

        // ----------------------------------------------
        // Handle player death.
        // ----------------------------------------------
        if (player.isAlive() == false) {
            this.player = new Tank(500, 500);
            this.addObject(this.player);
        }
    }

    // ----------------------------------------------
    // Input: handles for the player.
    // ----------------------------------------------
    public void setInput(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    // ----------------------------------------------
    // Rendering.
    // ----------------------------------------------
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

    public void spawn(Createfactory factory) {
        addObject(factory.create());
    }
}
