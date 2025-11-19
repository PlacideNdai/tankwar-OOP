package org.example.game;

import org.example.blueprints.Createfactory;
import org.example.blueprints.GameObject;
import org.example.entities.AutoTank;
import org.example.entities.Tank;

public class TankFactory implements Createfactory {

    public static Tank createTank(String type) {
        return switch (type) {
            case "enemy" -> new AutoTank();
            default -> new Tank(0, 0);
        };
    }

    @Override
    public GameObject create() {
        return createTank("enemy");
    }

}
