package org.example.entities;

import org.example.blueprints.GameObject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Tank extends GameObject {
    private Image tankImage;
    private Image upImage, downImage, leftImage, rightImage;

    public Tank(double x, double y) {
        this.x = x;
        this.y = y;
        this.tankImage = new Image(getClass().getResource("/images/tankU.gif").toExternalForm());
        this.upImage = new Image(getClass().getResource("/images/tankU.gif").toExternalForm());
        this.downImage = new Image(getClass().getResource("/images/tankD.gif").toExternalForm());
        this.leftImage = new Image(getClass().getResource("/images/tankL.gif").toExternalForm());
        this.rightImage = new Image(getClass().getResource("/images/tankR.gif").toExternalForm());
    }

    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public void rotate(double angle) {
        if(angle == 90) {
            tankImage = leftImage;
        } else if(angle == 180) {
            tankImage = downImage;
        } else if(angle == 270) {
            tankImage = rightImage;
        } else if(angle == 0) {
            tankImage = upImage;
        }
    }

    @Override
    public void update(double deltaTime) {}

    @Override
    public void render(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(tankImage, x, y);
    }
}
