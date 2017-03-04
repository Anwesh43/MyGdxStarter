package com.mygdx.game.objects;

/**
 * Created by anweshmishra on 13/09/16.
 */
public class RotatingLine {
    private float x,y,deg=0;
    public RotatingLine(float x,float y) {
        this.x = x;
        this.y = y;
    }
    public void move(float x,float y) {
        float x_diff = x-this.x;
        float y_diff= y - this.y;
        if(x_diff!=0) {
            float theta = (float) Math.atan(Math.abs(y_diff / x_diff)) * 180;
            theta = (float) (theta / (Math.PI));
            if (x_diff > 0) {
                if(y_diff == 0) {
                    deg = 0;
                }
                else {
                    deg = 360 + (Math.abs(y_diff)/y_diff)*theta;
                }
            }
            else {
                if(y_diff==0) {
                    deg = 180;
                }
                else {
                    deg = 180-(Math.abs(y_diff)/y_diff)*theta;
                }
            }
        }
        else {
            if(y_diff!=0) {
                deg = 90 * (Math.abs(y_diff) / y_diff);
            }
            else {
                deg = 90;
            }
        }
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
}
