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
    private double x, y;
    private double prevX, prevY;
    private String currentDirection = "north";

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
        prevX = x;
        prevY = y;

        x += dx;
        y += dy;
    }

    public void rotate(String direction) {
        if (direction.equals(Constants.WEST.getStringValue())) {
            tankImage = leftImage;
            this.currentDirection = Constants.WEST.getStringValue();
        } else if (direction.equals(Constants.SOUTH.getStringValue())) {
            tankImage = downImage;
            this.currentDirection = Constants.SOUTH.getStringValue();
        } else if (direction.equals(Constants.EAST.getStringValue())) {
            tankImage = rightImage;
            this.currentDirection = Constants.EAST.getStringValue();
        } else if (direction.equals(Constants.NORTH.getStringValue())) {
            tankImage = upImage;
            this.currentDirection = Constants.NORTH.getStringValue();
        }
    }

    public Bullet shoot(){
        double bx = x + width /2;
        double by = y + height /2;
        double dx =0, dy = 0;

        switch (currentDirection) {
            case "north":
                dy = -1;
                break;
            case "south":
                dy = 1;
                break;
            case "west":
                dx = -1;
                break;
            case "east":
                dx = 1;
                break;
        }

        return new Bullet(bx, by, dx, dy);
    }

    public void undoMove() {
        x = prevX;
        y = prevY;
    }

    @Override
    public void update(double deltaTime) {
    }

    @Override
    public void render(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(tankImage, this.x, this.y, this.width, this.height);
        graphicsContext.strokeRect(x, y, this.width, this.height);
    }
}
