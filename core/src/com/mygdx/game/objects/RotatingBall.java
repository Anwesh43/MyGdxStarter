package com.mygdx.game.objects;

/**
 * Created by anweshmishra on 28/09/16.
 */
public class RotatingBall {
    private float x,y,deg=0,radius,pivotx,pivoty;

    public float getPivoty() {
        return pivoty;
    }

    public void setPivoty(float pivoty) {
        this.pivoty = pivoty;
    }

    public float getPivotx() {
        return pivotx;
    }

    public void setPivotx(float pivotx) {
        this.pivotx = pivotx;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public RotatingBall(float pivotx,float pivoty,float radius) {

        this.pivotx = pivotx;
        this.pivoty = pivoty;
        this.radius = radius;
        this.x = (float)(radius*Math.cos(deg*Math.PI/180));
        this.y = (float)(radius*Math.sin(deg*Math.PI/180));
    }
    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public void setDeg(float deg) {
        this.deg = deg;
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
    public void move() {
        this.x = this.pivotx+(float)(this.radius*Math.cos(this.deg*Math.PI/180));
        this.y = this.pivoty+(float)(this.radius*Math.sin(this.deg*Math.PI/180));
        this.deg+=10;
    }
}
