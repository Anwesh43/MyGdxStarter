package com.mygdx.game.objects;

/**
 * Created by anweshmishra on 14/10/16.
 */
public class ToucheBall {
    private int mode = 0;
    private float x,y,deg=270,pivotx,pivoty,r,h;
    public ToucheBall(float x,float y,float r,float h) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.h = h;
    }
    public void move() {
        switch (mode) {
            case 0:
                y+=10;
                break;
            case 1:
                x = pivotx+(float)(r*Math.cos(deg*Math.PI/180));
                y = pivoty+(float)(r*Math.sin(deg*Math.PI/180));
                if(deg == 90) {
                    deg = 270;
                    mode = 0;
                }
                deg-=10;

                break;
            default:
                break;
        }
        if(y>=h) {
            y = 0;
            if(mode == 1) {
                pivoty = pivoty-h;
            }
        }
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public void setCircularMotion() {
        if(mode == 0) {
            mode = 1;
            this.pivotx = x;
            this.pivoty = y+r;
        }

    }
}
