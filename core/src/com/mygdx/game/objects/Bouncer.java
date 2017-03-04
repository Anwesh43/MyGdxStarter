package com.mygdx.game.objects;

import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

/**
 * Created by anweshmishra on 12/10/16.
 */
public class Bouncer {
    private float h;
    private int mode = 0;
    private Vector2 point,speed= new Vector2(0,0),scaleVector = new Vector2(0.1f,0.1f);
    public Bouncer(Vector2 point,float h) {
        this.point = point;
        this.h = h;
    }
    public void setSpeed(Vector2 speed) {
        this.speed = speed;
    }
    public Vector2 getPoint() {
        return point;
    }
    public Vector2 getSpeed() {
        return speed;
    }
    public void move() {
        switch (mode) {
            case 0:
                scaleVector = scaleVector.add(0.05f,0.05f);
                if(scaleVector.x >= 1.0f && scaleVector.y >= 1.0f) {
                    mode = 1;
                    scaleVector = new Vector2(1,1);
                }
                break;
            case 1:
                point.x += speed.x;
                point.y += speed.y;
                if (point.y >= h) {
                    point.y = h;
                    speed.y = -Math.abs(speed.y);
                }
                if (point.y <= 0) {
                    point.y = 0;
                    speed.y = Math.abs(speed.y);
                }
                break;
            default:
                break;
        }
    }

    public boolean equals(Object object) {
        return ((Bouncer)object).hashCode() == hashCode();
    }
    public int hashCode() {
        return speed.hashCode()+point.hashCode();
    }

    public float getH() {
        return h;
    }

    public Vector2 getScaleVector() {
        return scaleVector;
    }

    public int getMode() {
        return mode;

    }

}
