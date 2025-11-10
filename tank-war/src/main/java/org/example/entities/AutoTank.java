package org.example.entities;

import java.util.Random;

import org.example.blueprints.Constants;

public class AutoTank extends Tank {
    private Random random = new Random();
    private double moveTimer = 0;
    private double directionDuration = 2;
    private double dx = 0;
    private double dy = 0;

    public AutoTank() {
        super(new Random().nextInt(800), new Random().nextInt(600));
    }

    @Override
    public void update(double deltaTime) {
        moveTimer += deltaTime;

        if (moveTimer > directionDuration) {
            moveTimer = 0;
            directionDuration = 1 + random.nextDouble() * 2;
            int dir = random.nextInt(4);

            switch (dir) {
                case 0 -> {
                    dx = 1;
                    dy = 0;
                    rotate("east");
                }
                case 1 -> {
                    dx = -1;
                    dy = 0;
                    rotate("west");
                }
                case 2 -> {
                    dx = 0;
                    dy = 1;
                    rotate("south");
                }
                case 3 -> {
                    dx = 0;
                    dy = -1;
                    rotate("north");
                }
            }
        }

        // move.
        move(dx * 100 * deltaTime, dy * 100 * deltaTime);
    }

    public void inBounds() {
        if (x < 0) {
            x = 0;
            dx = 1;
        } else if (x + width > Constants.GAME_WIDTH.getIntValue()) {
            x = Constants.GAME_WIDTH.getIntValue() - width;
            dx = -1;
        }

        if (y < 0) {
            y = 0;
            dy = 1;
        } else if (y + height > Constants.GAME_HEIGHT.getIntValue()) {
            y = Constants.GAME_HEIGHT.getIntValue() - height;
            dy = -1;
        }
    }
}
