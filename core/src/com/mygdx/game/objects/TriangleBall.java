package com.mygdx.game.objects;

/**
 * Created by anweshmishra on 16/10/16.
 */
public class TriangleBall {
    private float x,y,h,initialX,initialY,r;
    private int mode = 0;
    public TriangleBall(float x,float y,float h,float r) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.r = r;
        this.initialX = x;
        this.initialY = y;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    //This is the main part
    public void move() {
        y-=10;//incrementing y
        if(y<=0) {
            y +=h;
        }
        switch (mode) {
            case 0:
                initialY = y;
                break;
            case 1:
                if(y<=0) {
                    initialY = h+initialY;
                }
                if(y<=initialY-2*r) {

                    mode = 0;
                    y = initialY-2*r;
                    x = initialX;
                }
                else {
                    if(y!=initialY+r) {
                        float change = y-(initialY-r);
                        x+=10*(change/Math.abs(change));
                    }
                }
                break;
            default:
                break;
        }
    }
    public void changeMode() {
        if(mode == 0) {
            initialX = x;
            initialY = y;
            mode = 1;
        }
    }

}
