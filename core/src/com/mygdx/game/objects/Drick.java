package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by anweshmishra on 02/11/16.
 */
public class Drick {
    private float x=0,y,deg=0,x1;
    private int mode = 0;
    private boolean isOver = false;
    private Sprite sprite;
    public Drick(float x1,float y,Sprite sprite) {
        this.x1 = x1-x1%10;
        this.y = y;
        this.sprite = sprite;
    }
    public Sprite getSprite() {
        return sprite;
    }
    public void shouldMove() {
        if(!isOver) {
            move();
        }
    }
    private void move() {
        switch(mode) {
            case 0:
                x+=10;
                if(x>=x1) {
                    mode = 1;
                }
                break;
            case 1:
                deg+=3;
                if(deg>=360 && !isOver) {
                    isOver = true;
                }
                break;
            default:
                break;
        }
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getDeg() {
        return deg;
    }

    public void setDeg(float deg) {
        this.deg = deg;
    }

    public float getX1() {
        return x1;
    }

    public void setX1(float x1) {
        this.x1 = x1;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public void setOver(boolean over) {
        isOver = over;
    }

    public boolean isOver() {
        return isOver;

    }
    public int hashCode() {
        return (int)x1+(int)mode+(int)deg+(int)x+(int)y;
    }
}
