package com.mygdx.game.objects;

/**
 * Created by anweshmishra on 15/10/16.
 */
public class SquareContainBall {
    private float x,y,initialX,initialY,side,h;
    private int mode = 0;

    public SquareContainBall(float x,float y,float side,float h) {
        this.x = x;
        this.y = y;
        this.initialX = x;
        this.initialY = y;
        this.h = h;
        this.side = side;
    }

    public void move() {
        switch(mode) {
            case 0:
                y+=10;
                initialY = y;
                break;
            case 1:
                if(y<initialY+side) {
                    if(x<=initialX+side) {
                        x+=10;
                    }
                    else {
                        y+=10;
                    }
                }
                else {
                    if(x>=initialX) {
                        x-=10;
                    }
                    else {
                        x = initialX;
                        mode = 0;
                    }
                }
                break;
            default:
                break;

        }
        if(y>=h) {
            y=0;
            if(mode == 0) {
                initialY -=h;
            }
        }
    }
    public void changeToSquareMode() {
        if(mode == 0) {
            mode = 1;
        }
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
}
