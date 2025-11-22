package org.example.entities;

import org.example.blueprints.Constants;
import org.example.blueprints.GameObject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Bullet extends GameObject {
    private double dx, dy;
    private double speed;
    private Image bulletImage;
    private String direction;
    private Tank owner;
    private Image upBulletImage, downBulletImage, leftBulletImage, rightBulletImage;

    public Bullet(double x, double y, double dx, double dy, String direction, Tank owner) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.direction = direction;
        this.owner = owner;
        this.speed = Constants.BULLET_SPEED.getIntValue();

        this.bulletImage = new Image(getClass().getResource("/images/missileD.gif").toString());
        this.upBulletImage = new Image(getClass().getResource("/images/missileU.gif").toString());
        this.downBulletImage = new Image(getClass().getResource("/images/missileD.gif").toString());
        this.leftBulletImage = new Image(getClass().getResource("/images/missileL.gif").toString());
        this.rightBulletImage = new Image(getClass().getResource("/images/missileR.gif").toString());

        this.width = this.bulletImage.getWidth();
        this.height = this.bulletImage.getHeight();
    }

    @Override
    public void update(double deltaTime) {
        x += dx * speed * deltaTime;
        y += dy * speed * deltaTime;

        this.getBullImage(direction);

        inBounds();
    }

    @Override
    public void onCollide(GameObject otherObj) {
        if (otherObj instanceof Tank tank && tank != getOwner()) {
            this.destroy();
        }

        if (otherObj instanceof Wall) {
            this.destroy();
        }
    }

    @Override
    public void render(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(bulletImage, x, y, width, height);
    }

    public Image getBullImage(String direction) {
        if (direction.equals(Constants.NORTH.getStringValue())) {
            return bulletImage = upBulletImage;
        } else if (direction.equals(Constants.SOUTH.getStringValue())) {
            return bulletImage = downBulletImage;
        } else if (direction.equals(Constants.EAST.getStringValue())) {
            return bulletImage = rightBulletImage;
        } else if (direction.equals(Constants.WEST.getStringValue())) {
            return bulletImage = leftBulletImage;
        }
        return null;
    }

    public Tank getOwner() {
        return owner;
    }

    public void inBounds() {
        if (x < 0) {
            this.destroy();
        } else if (x + width > Constants.GAME_WIDTH.getIntValue()) {
            this.destroy();
        }

        if (y < 0) {
            this.destroy();
        } else if (y + height > Constants.GAME_HEIGHT.getIntValue()) {
            this.destroy();
        }
    }
}
