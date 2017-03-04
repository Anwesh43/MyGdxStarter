package com.mygdx.game.objects;

/**
 * Created by anweshmishra on 08/10/16.
 */
public class GrukBall {
    private float x,r,pivotx,pivoty,y,deg=0,mode=0;
    public GrukBall(float pivotx,float pivoty,float r) {
        this.pivotx = pivotx;
        this.pivoty = pivoty;
        this.r = r;
        this.x = this.pivotx+(float)(this.r*Math.cos(this.deg*Math.PI/180));
        this.y = this.pivoty+(float)(this.r*Math.sin(this.deg*Math.PI/180));
    }
    public void changeMode() {
        if(mode == 0) {
            mode = 1;
        }
    }
    public void move() {
        x = pivotx+(float)(r*Math.cos(deg*Math.PI/180));
        y = pivoty+(float)(r*Math.sin(deg*Math.PI/180));
        deg += (1-mode)*10;
        r += mode*10;
    }
    public float getX() {
        return x;
    }
    public float getR() {
        return r;
    }
    public float getY() {
        return y;
    }
    public boolean equals(Object object) {
        GrukBall ball = (GrukBall)object;
        return ball.hashCode() == hashCode();
    }
    public int hashCode() {
        return (int)x+(int)y+(int)r+(int)pivotx+(int)pivoty;
    }
}
