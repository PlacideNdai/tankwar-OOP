package org.example.blueprints;

public enum Constants {
    // ----------------------------------------------
    // game constants.
    // ----------------------------------------------
    GAME_WIDTH(800),
    GAME_HEIGHT(600),

    // ----------------------------------------------
    // speed constants.
    // ----------------------------------------------
    NORMAL_SPEED(100),

    // ----------------------------------------------
    // tank constants.
    // ----------------------------------------------
    TANK_HEIGHT(50), TANK_WIDTH(50),



    // ----------------------------------------------
    // directions constants.
    // ----------------------------------------------
    NORTH("north"), SOUTH("south"), EAST("east"), WEST("west"),



    // ----------------------------------------------
    // Wall constants.
    // ----------------------------------------------
    WALL_HEIGHT(50), WALL_WIDTH(50);

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
