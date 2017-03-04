package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;

/**
 * Created by anweshmishra on 24/10/16.
 */
public class Clock {
    private float x,y,deg=0;
    private boolean isRotated = false;
    public Clock(float x,float y) {
        this.x = x;
        this.y = y;
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
    public boolean isRotated() {
        return isRotated;
    }
    public void move() {
        deg+=10;
        if(deg>360) {
            isRotated = true;
        }
    }
    public int hashCode() {
        int isRotatedVal = isRotated?1:0;
        return (int)x+(int)y+(int)deg+isRotatedVal;
    }
}
