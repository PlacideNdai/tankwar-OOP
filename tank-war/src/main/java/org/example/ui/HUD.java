package org.example.ui;

import org.example.entities.Tank;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class HUD {
    private Tank player;

    public HUD(Tank player) {
        this.player = player;
    }


    public void render(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(10, 10, 200, 30);

        graphicsContext.setFill(Color.RED);
        double healthWidth = 200 * player.getHealth() / player.getMaxHealth();
        graphicsContext.fillRect(10, 10, healthWidth, 0);
    }
}
