package org.example.ui;

import org.example.entities.Tank;

import javafx.scene.canvas.GraphicsContext;

public class HUD {
    private Tank player;

    public HUD(Tank player) {
        this.player = player;
    }


    public void render(GraphicsContext graphicsContext) {
        graphicsContext.fillText("Kills: " + player.getPoints(), 10, 30);
    }
}
