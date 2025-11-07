package org.example.entities;

import org.example.blueprints.Constants;
import org.example.blueprints.GameObject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Tank extends GameObject {
    private Image tankImage;
    private Image upImage, downImage, leftImage, rightImage;
    private double health;
    private double maxHealth;


    public Tank(double x, double y) {
        this.x = x;
        this.y = y;
        this.width = Constants.TANK_WIDTH.getIntValue();
        this.height = Constants.TANK_HEIGHT.getIntValue();
        this.health = 100;
        this.maxHealth = 100;

        // --------------------------------------------------------------------------------------------
        // Tank Images
        // --------------------------------------------------------------------------------------------
        this.tankImage = new Image(getClass().getResource("/images/tankU.gif").toExternalForm());
        this.upImage = new Image(getClass().getResource("/images/tankU.gif").toExternalForm());
        this.downImage = new Image(getClass().getResource("/images/tankD.gif").toExternalForm());
        this.leftImage = new Image(getClass().getResource("/images/tankL.gif").toExternalForm());
        this.rightImage = new Image(getClass().getResource("/images/tankR.gif").toExternalForm());
    }

    // ---------------------------------------
    // getters and setters.
    // ---------------------------------------
    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    // ---------------------------------------
    // movement.
    // ---------------------------------------
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public void rotate(String direction) {
        if(direction.equals(Constants.WEST.getStringValue())) {
            tankImage = leftImage;
        } else if(direction.equals(Constants.SOUTH.getStringValue())) {
            tankImage = downImage;
        } else if(direction.equals(Constants.EAST.getStringValue())) {
            tankImage = rightImage;
        } else if(direction.equals(Constants.NORTH.getStringValue())) {
            tankImage = upImage;
        }
    }

    @Override
    public void update(double deltaTime) {}

    @Override
    public void render(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(tankImage, x, y, width, height);
    }
}
