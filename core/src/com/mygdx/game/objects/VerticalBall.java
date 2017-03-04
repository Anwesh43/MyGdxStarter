package com.mygdx.game.objects;

/**
 * Created by anweshmishra on 04/10/16.
 */
public class VerticalBall {
    private float x,y,diry=20,r;
    public VerticalBall(float x,float y,float r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
    public void move() {
        y+=diry;
    }
    public boolean equals(Object obj) {
        return ((VerticalBall)obj).hashCode() == hashCode();
    }
    public int hashCode() {
        return (int)x+(int)y+(int)diry;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public boolean collide(StoppingLine line) {
        return line.getX() +line.getW()>= x-r && line.getX()-line.getW()<=x+r && line.getY()+line.getW() >= y-r && line.getY()-line.getW()<= y+r;
    }
}
