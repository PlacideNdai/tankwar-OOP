package org.example.entities;

import java.util.Random;

import org.example.blueprints.GameObject;

import javafx.scene.canvas.GraphicsContext;

public class Heals extends GameObject {
    private double randomLocX = new Random().nextDouble(800), randomLocY = new Random().nextDouble(600);


    public Heals() {
        
        this.x = randomLocX;
        this.y = randomLocY;
    }

    @Override
    public void update(double deltaTime) {

    }

    @Override
    public void render(GraphicsContext graphicsContext) {
        graphicsContext.setFill(javafx.scene.paint.Color.GREEN);
        graphicsContext.fillRect(x, y, 25, 25);
    }

    @Override
    public void onCollide(GameObject obj) {
        if (obj instanceof Tank tank) {
            tank.heal();
            this.destroy();
        }

        if (obj instanceof Wall wall) {
            this.destroy();
        }
    }

}
