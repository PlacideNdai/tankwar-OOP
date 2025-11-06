package org.example.blueprints;

import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;

public abstract class GameObject {
    protected double x, y;
    protected double width, height;
    protected ImageView sprite;

    public abstract void update(double deltaTime);
    public abstract void render(GraphicsContext graphicsContext);

    public Bounds getBounds(){
        return sprite.getBoundsInParent();
    }
}
