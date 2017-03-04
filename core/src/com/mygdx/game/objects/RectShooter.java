package com.mygdx.game.objects;

/**
 * Created by anweshmishra on 02/09/16.
 */
public class RectShooter {
    private float x,y,deg;
    private float direction;
    private boolean isFinished = true;
    public RectShooter(float x,float y,float deg) {
        this.x = x;
        this.y = y;
        this.deg = deg;
    }
    public void changeDirection(int direction) {
        isFinished = false;
        this.direction = direction;

    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public float getDeg() {
        return deg;
    }
    public void move() {
        if(!isFinished) {
            this.deg += this.direction*10;
            if (Math.abs(this.deg) == 180 || Math.abs(this.deg) == 0) {
                isFinished = true;
            }
        }
    }
    public void moveY(float distance) {
        this.y+=distance;
    }
    public boolean isFinishedMoving() {
        return isFinished;
    }
}
