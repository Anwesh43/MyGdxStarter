package com.mygdx.game.objects;

/**
 * Created by anweshmishra on 03/11/16.
 */
public class Nipper {
    private float x,y,deg=0,boundary;
    private int mode = 0;
    private boolean overBoundary = false;
    public Nipper(float x,float y,float boundary) {
        this.x = x;
        this.y = y;
        this.boundary = boundary;
    }
    public void move() {
        switch(mode) {
            case 0:
                deg+=5;
                if(deg>=180) {
                    mode = 1;
                }
                break;
            case 1:
                y+=5;
                if(y>=boundary*0.9f) {
                    overBoundary = true;
                }

        }
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
    public boolean isOverBoundary() {
        return overBoundary;
    }
    public int hashCode() {
        return (int)x+(int)y+(int)deg+(overBoundary?1:0);
    }
}
