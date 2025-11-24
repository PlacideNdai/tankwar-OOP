package org.example.entities;

import org.example.blueprints.Constants;
import org.example.blueprints.GameObject;
import org.example.blueprints.Life;
import org.example.ui.HUD;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Tank extends GameObject implements Life {
    private Image tankImage;
    private Image upImage, downImage, leftImage, rightImage;
    private double prevX, prevY;
    private String currentDirection = "north";
    private int health;
    private int points = 0;
    private HUD hub;

    public Tank(double x, double y) {
        this.x = x;
        this.y = y;
        this.hub = new HUD(this);
        // --------------------------------------------------------------------------------------------
        // Tank Images
        // --------------------------------------------------------------------------------------------
        this.tankImage = new Image(getClass().getResource("/images/tankU.gif").toExternalForm());
        this.upImage = new Image(getClass().getResource("/images/tankU.gif").toExternalForm());
        this.downImage = new Image(getClass().getResource("/images/tankD.gif").toExternalForm());
        this.leftImage = new Image(getClass().getResource("/images/tankL.gif").toExternalForm());
        this.rightImage = new Image(getClass().getResource("/images/tankR.gif").toExternalForm());

        this.width = tankImage.getWidth();
        this.height = tankImage.getHeight();

        // ----------------------------------
        // health.
        // ----------------------------------
        this.health = 100;
    }

    // ---------------------------------------
    // PLAYER FUNCTIONS.
    // ---------------------------------------
    public void move(double dx, double dy) {
        prevX = x;
        prevY = y;

        x += dx;
        y += dy;
    }

    @Override
    public void onCollide(GameObject otherObj) {
        if (otherObj instanceof Wall) {
            this.undoMove();
        }

        if (otherObj instanceof Bullet bullet) {
            if (bullet.getOwner() != this && health > 0) {
                takeDamage(20);
            } else if (health <= 0) {
                this.destroy();
                bullet.destroy();
                bullet.getOwner().gainPoint();
            }
        }

        if (otherObj instanceof Tank tank) {
            tank.undoMove();
        }

        if (otherObj instanceof Heals heals) {
            heals.destroy();
            this.heal();
        }
    }

    @Override
    public void update(double deltaTime) {
    }

    @Override
    public void render(GraphicsContext graphicsContext) {
        double barWidth = width;
        double barHeight = 10;
        double barX = x;
        double barY = y + barHeight - 25;

        double healthPercent = (double) health / 100;
        double healthFill = barWidth * healthPercent;

        graphicsContext.setFill(javafx.scene.paint.Color.DARKRED);
        graphicsContext.fillRect(barX, barY, healthFill, barHeight);

        graphicsContext.drawImage(tankImage, this.x, this.y, width, height);
    }

    // ---------------------------------------
    // GETTERS, SETTERS, AND MORE.
    // ---------------------------------------
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

    public Bullet shoot() {
        double bx = x + width / 2;
        double by = y + height / 2;
        double dx = 0, dy = 0;

        switch (currentDirection) {
            case "north":
                dy = -1;
                by = y - 20;
                break;
            case "south":
                dy = 1;
                by = y + height + 20;
                break;
            case "west":
                dx = -1;
                break;
            case "east":
                dx = 1;
                break;
        }

        return new Bullet(bx, by, dx, dy, currentDirection, this);
    }

    public void undoMove() {
        x = prevX;
        y = prevY;
    }

    // ---------------------------------------
    // from LIFE.
    // ---------------------------------------
    @Override
    public void takeDamage(int damage) {
        health -= damage;
    }

    @Override
    public void heal() {
        health = 100;
    }

    @Override
    public int getHealth() {
        return health;
    }

    public void gainPoint() {
        points += 1;
    }

    public int getPoints(){
        return points;
    }
}
