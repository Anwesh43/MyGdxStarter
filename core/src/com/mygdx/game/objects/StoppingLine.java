package com.mygdx.game.objects;

/**
 * Created by anweshmishra on 04/10/16.
 */
public class StoppingLine {
    private float x,y,w;
    public StoppingLine(float x,float y,float w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }
    public boolean equals(Object object) {
        return ((StoppingLine)object).hashCode() == hashCode();
    }
    public int hashCode() {
        return (int)x+(int)y+(int)w;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public float getW() {
        return w;
    }
}
