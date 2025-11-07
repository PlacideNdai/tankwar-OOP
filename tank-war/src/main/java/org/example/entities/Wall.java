package org.example.entities;

import org.example.blueprints.Constants;
import org.example.blueprints.GameObject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Wall extends GameObject{
    private double x, y;
    private double width, height;
    private Image wallImage;

    public Wall(double x, double y){
        this.x = x;
        this.y = y;
        this.width = Constants.WALL_WIDTH.getIntValue();
        this.height = Constants.WALL_HEIGHT.getIntValue();
        this.wallImage = new Image(getClass().getResource("/images/wall.png").toExternalForm());

    }



    @Override
    public void update(double deltaTime) {

    }

    @Override
    public void render(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(wallImage, x, y, width, height);
    }
    
}
