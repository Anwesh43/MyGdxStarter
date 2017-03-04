package com.mygdx.game.objects;

/**
 * Created by anweshmishra on 29/10/16.
 */
public class Dumble {
    private float x,y,deg=0,w,h;
    public Dumble(float x,float y,float w,float h) {
        this.x = x;
        this.w = w;
        this.h = h;
        this.y = y;
    }
    public void move() {
        this.deg+=10;
    }
    public boolean contains(int x,int y) {
        return x>=this.x-w && x<=this.x+w && y>=this.y-h && y<=this.y+h;
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
    public void moveXY(float x,float y) {
        this.x = x;
        this.y = y;
    }
    public int hashCode() {
        return (int)x+(int)y+(int)w+(int)h;
    }
    public boolean equals(Object o) {
        return ((Dumble)o).hashCode() == hashCode();
    }
}
