package com.mygdx.game;

/**
 * Created by anweshmishra on 28/08/16.
 */
public class Body {
    private float x,y,deg;
    public Body(float x,float y,float deg) {
        this.x = x;
        this.y = y;
        this.deg = deg;
    }
    public void setX(float x) {
        this.x = x;
    }
    public float getX() {
        return x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public float getY() {
        return y;
    }
    public float getDeg() {
        return deg;
    }
    public void setDeg(float deg) {
        this.deg = deg;
    }
    public boolean equals(Object bodyobj) {
        Body body = (Body)bodyobj;
        return body.getX() == x && body.getY() == y && body.getDeg() == deg;
    }
    public int hashCode() {
        return (int)(x*x+y*y+deg*deg-x-y-deg);
    }
}
