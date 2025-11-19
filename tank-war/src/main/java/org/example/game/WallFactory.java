package org.example.game;

import org.example.blueprints.Createfactory;
import org.example.blueprints.GameObject;
import org.example.entities.Wall;

public class WallFactory implements Createfactory{
    private double x, y;
    
    public WallFactory(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public GameObject create() {
        return new Wall(x, y);
    }

}
