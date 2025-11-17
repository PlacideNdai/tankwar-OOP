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
        return (x < gameObject.getX() + gameObject.getWidth() &&
                x + width > gameObject.getX() &&
                y < gameObject.getY() + gameObject.getHeight() &&
                y + height > gameObject.getY());
    }

    public abstract void onCollide(GameObject obj);

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
