package com.mygdx.game.objects;

/**
 * Created by anweshmishra on 05/09/16.
 */
public class Cross {
    private Point start;
    private float deg,direction;
    public Cross(Point start) {
        this.start = start;
    }
    public void setDeg(float deg) {
        this.deg = deg;
    }
    public float getDeg() {
        return deg;
    }
    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public float getDirection() {
        return direction;
    }

    public void setDirection(float direction) {
        this.direction = direction;
    }

    public void move() {
        this.start.x+=direction*10;
        this.deg+=3*direction;
    }
    public boolean equals(Object o) {
        Cross cross = (Cross)o;
        return cross.hashCode() == hashCode();
    }
    public int hashCode() {
        return start.hashCode()+(int)deg;
    }
}
