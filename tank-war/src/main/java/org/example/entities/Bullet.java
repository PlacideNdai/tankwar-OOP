package org.example.entities;


import org.example.blueprints.Constants;
import org.example.blueprints.GameObject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Bullet extends GameObject {
    private double x, y, dx, dy;
    private double width, height;
    private double speed;
    private Image bulletImage;
    private Image upBulletImage, downBulletImage, leftBulletImage, rightBulletImage;

    public Bullet(double x, double y, double dx, double dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.width = Constants.BULLET_WIDTH.getIntValue();
        this.height = Constants.BULLET_HEIGHT.getIntValue();
        this.speed = Constants.BULLET_SPEED.getIntValue();

        this.bulletImage = new Image(getClass().getResource("/images/missileD.gif").toString());
        this.upBulletImage = new Image(getClass().getResource("/images/missileU.gif").toString());
        this.downBulletImage = new Image(getClass().getResource("/images/missileD.gif").toString());
        this.leftBulletImage = new Image(getClass().getResource("/images/missileL.gif").toString());
        this.rightBulletImage = new Image(getClass().getResource("/images/missileR.gif").toString());
    }

    @Override
    public void update(double deltaTime) {
        x += dx * speed * deltaTime;
        y += dy *speed * deltaTime;
    }

    @Override
    public void render(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(bulletImage, x, y, width, height);
    }
    
    
}
