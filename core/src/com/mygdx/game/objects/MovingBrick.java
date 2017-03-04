package com.mygdx.game.objects;

/**
 * Created by anweshmishra on 26/11/16.
 */
public class MovingBrick {
    private float x,y,dirY = 0,deg = 0,rotSpeed=0,prevDeg=0;
    public float getDirY() {
        return dirY;
    }
    public void setRotSpeed(float rotSpeed) {
        this.rotSpeed = rotSpeed;
    }
    public float getDeg() {
        return deg;
    }
    public float getRotSpeed() {
        return rotSpeed;
    }
    public void setDirY(float dirY) {
        this.dirY = dirY;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return  y;
    }
    public MovingBrick(float x,float y) {
        this.x = x;
        this.y = y;
    }
    public int hashCode() {
        return (int)x+(int)y+(int)dirY;
    }
    public void move(float h) {
        this.y+=dirY;
        this.deg+=this.rotSpeed;
        if(this.y>=h) {
            this.y = 0;
        }
        if(this.y<0) {
            this.y = h;
        }
        if(this.rotSpeed != 0 && Math.abs(this.deg-this.prevDeg) >= 180) {
            this.dirY = this.rotSpeed;
            this.rotSpeed = 0;
            this.prevDeg = deg;
        }
    }
}
