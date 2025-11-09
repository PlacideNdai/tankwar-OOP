package org.example.blueprints;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;

public abstract class GameObject {
    protected double x, y;
    protected double width, height;
    protected ImageView sprite;

    public abstract void update(double deltaTime);

    public abstract void render(GraphicsContext graphicsContext);

    public boolean collidesWith(GameObject gameObject) {
        double halfW = width / 2;
        double halfH = height / 2;
        double otherHalfW = gameObject.getWidth() / 2;
        double otherHalfH = gameObject.getHeight() / 2;

        return (x - halfW < gameObject.getX() + otherHalfW &&
                x + halfW > gameObject.getX() - otherHalfW &&
                y - halfH < gameObject.getY() + otherHalfH &&
                y + halfH > gameObject.getY() - otherHalfH);
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
