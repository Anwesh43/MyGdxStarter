package com.mygdx.game.objects;

/**
 * Created by anweshmishra on 26/09/16.
 */
public class Rotator {
    private int length,deg;
    private int l = 1;
    public Rotator(int length,int deg) {
        this.length = length;
        this.deg = deg;
    }
    public void move() {
        this.deg+=l;
        if(this.deg%180 == 0) {
            this.l*=-1;
        }
    }
    public float decideX(){
        return (float)(length*Math.cos(deg*Math.PI/180));
    }
    public float decideY(){
        return (float)(length*Math.sin(deg*Math.PI/180));
    }
    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
