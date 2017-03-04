package com.mygdx.game.objects;

import java.awt.Canvas;

/**
 * Created by anweshmishra on 13/10/16.
 */
public class Rounder {
    private float x,y,deg = -180,r=200,pivotx,pivoty,rot=0,scale=0;int mode=0;
    public Rounder(float x,float y) {
        this.pivotx = x;
        this.pivoty = y;
        this.x = this.pivotx+r*(float)(Math.cos(this.deg*Math.PI/180));
        this.y = this.pivoty+r*(float)(Math.sin(this.deg*Math.PI/180));
    }
    public void move() {
        this.x = this.pivotx+r*(float)(Math.cos(this.deg*Math.PI/180));
        this.y = this.pivoty+r*(float)(Math.sin(this.deg*Math.PI/180));
        switch(mode) {
            case 0:
                scale+=Math.abs(rot/400);
                if(scale >= 1) {
                    scale = 1;
                    mode = 1;
                }
                break;
            case 1:
                this.deg +=this.rot;
                if(this.deg == 0) {
                    this.deg = -180;
                    this.pivotx+=2*this.r;
                }
                break;
            default:
                break;
        }

    }
    public void setRot(float rot) {
        this.rot = rot;
    }
    public float getX() {
        return this.x;
    }
    public float getY() {
        return this.y;
    }
    public float getScale() {
        return this.scale;
    }
    public int hashCode() {
        return (int)this.x+(int)this.y+(int)this.deg+(int)this.pivotx+(int)this.pivoty;
    }
}
