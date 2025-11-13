package org.example.entities;

import org.example.blueprints.Constants;
import org.example.blueprints.GameObject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Wall extends GameObject{

    public Wall(double x, double y){
        this.x = x;
        this.y = y;
        this.width = Constants.WALL_WIDTH.getIntValue();
        this.height = Constants.WALL_HEIGHT.getIntValue();
    }



    @Override
    public void update(double deltaTime) {

    }

    @Override
    public void render(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Color.BROWN);
        graphicsContext.setStroke(Color.RED);
        graphicsContext.fillRect(x, y, this.width, this.height);
        graphicsContext.strokeRect(x, y, this.width, this.height);
    }
    
}
