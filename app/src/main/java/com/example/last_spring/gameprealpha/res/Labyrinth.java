package com.example.last_spring.gameprealpha.res;

public class Labyrinth {

    private String name;
    private boolean isNorth;
    private boolean isSouth;
    private boolean isWest;
    private boolean isEast;
    private boolean isStart;
    private boolean isFinish;
    private boolean isAir;
    private String text;


    public Labyrinth(String name, boolean isNorth, boolean isSouth, boolean isWest, boolean isEast, boolean isStart, boolean isFinish, boolean isAir, String text) {
        this.name = name;
        this.isNorth = isNorth;
        this.isSouth = isSouth;
        this.isWest = isWest;
        this.isEast = isEast;
        this.isStart = isStart;
        this.isFinish = isFinish;
        this.isAir = isAir;
        this.text = text;
    }

    public  String getName() {
        return name;
    }

    public boolean isNorth() {
        return isNorth;
    }

    public boolean isSouth() {
        return isSouth;
    }

    public boolean isWest() {
        return isWest;
    }

    public boolean isEast() {
        return isEast;
    }

    public boolean isStart() {
        return isStart;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public boolean isAir() {
        return isAir;
    }

    public String getText() {
        return text;
    }
}
