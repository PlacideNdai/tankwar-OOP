package org.example.blueprints;

public enum Constants {
    GAME_WIDTH(800),
    GAME_HEIGHT(600),
    NORMAL_SPEED(100),
    NORTH("north"), SOUTH("south"), EAST("east"), WEST("west");

    private String name;
    private int value;

    Constants(String name){
        this.name = name;
    }

    Constants(int value){
        this.value = value;
    }

    public int getIntValue(){
        return value;
    }

    public String getStringValue(){
        return name;
    }
}
