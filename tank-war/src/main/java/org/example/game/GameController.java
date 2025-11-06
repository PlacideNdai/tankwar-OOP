package org.example.game;

import java.util.ArrayList;
import java.util.List;

import org.example.blueprints.GameObject;

import javafx.scene.canvas.GraphicsContext;

public class GameController {
    private GraphicsContext graphicsContext;
    private final List<GameObject> objectsInGame = new ArrayList<>();

    public GameController(GraphicsContext context){
        this.graphicsContext = context;
    }

    public void update(double deltaTime){
        for(GameObject obj : objectsInGame){
            obj.update(deltaTime);
        }
    }

    public void render(){
        graphicsContext.clearRect(0, 0, 800, 600);

        for(GameObject obj : objectsInGame){
            obj.render(graphicsContext);
        }
    }
}
