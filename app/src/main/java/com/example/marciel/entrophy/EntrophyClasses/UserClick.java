package com.example.marciel.entrophy.EntrophyClasses;

public class UserClick {

    private int ticTime;
    private float x;
    private float y;

    public UserClick(int ticTime, float x, float y) {
        this.ticTime = ticTime;
        this.x = x;
        this.y = y;
    }

    public int getTicTime() {
        return ticTime;
    }

    public void setTicTime(int ticTime) {
        this.ticTime = ticTime;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
