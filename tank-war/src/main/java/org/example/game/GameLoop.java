package org.example.game;

import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer{

    private long lastTime = 0;
    private GameController controller;

    public GameLoop(GameController controller){
        this.controller = controller;
    }

    @Override
    public void handle(long now){
        if(lastTime > 0){
            double deltaTime = (now - lastTime) / 1e9;
            controller.update(deltaTime);
            controller.render();
        }
        lastTime = now;
    }
}
