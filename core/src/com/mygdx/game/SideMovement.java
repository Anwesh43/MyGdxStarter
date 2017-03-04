package com.mygdx.game;

/**
 * Created by anweshmishra on 01/09/16.
 */
public class SideMovement {
    private float x,y,deg,direction;
    public SideMovement(float x,float y,float deg,float direction) {
        this.x = x;
        this.y = y;
        this.deg = deg;
        this.direction = direction;
    }
    public void move() {
        if(Math.abs(deg)<90) {
            deg-=10*direction;
        }
        else {
            x+=10*direction;
        }
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

    public float getDeg() {
        return deg;
    }

    public void setDeg(float deg) {
        this.deg = deg;
    }
    public void setDirection(float direction) {
        this.direction = direction;
    }
    public float getDirection() {
        return direction;
    }
    public boolean equals(Object object) {
        return ((SideMovement)object).hashCode() == hashCode();
    }
    public int hashCode() {
        return (int)(x+x+y+y+deg*direction);
    }
}
