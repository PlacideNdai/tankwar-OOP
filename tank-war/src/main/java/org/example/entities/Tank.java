package org.example.entities;

import org.example.blueprints.GameObject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Tank extends GameObject {
    private int speed = 100;

    public Tank(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(double deltaTime) {
        x += speed * deltaTime;
    }

    @Override
    public void render(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Color.ALICEBLUE);
        graphicsContext.fillRect(x, y, 40, 40);
    }
}
