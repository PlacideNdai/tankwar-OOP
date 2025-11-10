package org.example.input;

import javafx.scene.Scene;

public class InputHandler {
    private boolean up, down, left, right, shoot;

    public void attach(Scene scene) {
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case W: up = true;
                case S: down = true;
                case A: left = true;
                case D: right = true;
                case SPACE: shoot = true;
                default: {};
            }
        });

        scene.setOnKeyReleased(e -> {
            switch (e.getCode()) {
                case W -> up = false;
                case S -> down = false;
                case A -> left = false;
                case D -> right = false;
                case SPACE -> shoot = false;
                default -> {}
            }
        });
    }

    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isShoot() {
        return shoot;
    }
}
