package com.mygdx.game.objects;

/**
 * Created by anweshmishra on 30/10/16.
 */
public class Diver {
    private float x,y,dir=1,deg=0,l=1,w;
    public Diver(float x,float y,float w) {
        this.x = x;
        this.y = y;
        this.w = w;
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
    public void toggleDir() {
        this.dir*=-1;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getDir() {
        return dir;
    }

    public void setDir(float dir) {
        this.dir = dir;
    }

    public void setDeg(float deg) {
        this.deg = deg;
    }

    public float getL() {
        return l;
    }

    public void setL(float l) {
        this.l = l;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }

    public void move() {
        deg+=l*2;
        if(deg >= 60)  {
            l = -1;
        }
        else if(deg<=0){
            l = 1;
        }
        x+=dir*10;
        if(x>=w) {
            x = 0;
        }
        else if(x<=0) {
            x = w;
        }
    }
}
