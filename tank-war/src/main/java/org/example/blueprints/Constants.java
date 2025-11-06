package org.example.blueprints;

public enum Constants {
    GAME_WIDTH(800),
    GAME_HEIGHT(600);

    private int value;

    Constants(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
