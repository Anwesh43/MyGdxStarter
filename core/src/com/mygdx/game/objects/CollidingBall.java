package com.mygdx.game.objects;

/**
 * Created by anweshmishra on 11/09/16.
 */
public class CollidingBall {
    private float x,y,speedy,speedx=0,lowerBound=0,upperBound;
    private long initialTime,finalTime;
    public CollidingBall(float x,float y,float upperBound) {
        this.x = x;
        this.y = y;
        this.upperBound = upperBound;
    }
    public void setSpeedY(float x,float y) {
        this.upperBound = upperBound;
        float x_gap = Math.abs(x-this.x),y_gap = (Math.abs(this.y-y));
        float speed = (40*y_gap)/(float)(Math.sqrt(x_gap*x_gap+y_gap*y_gap));
        speedx = -speed*x_gap/y_gap;
        speedy = speed*((y_gap)/(y-this.y));
        initialTime = System.currentTimeMillis();
    }

    public long getFinalTime() {
        return finalTime;
    }

    public void setFinalTime(long finalTime) {
        this.finalTime = finalTime;
    }

    public void move() {

        x+=speedx;
        y+=speedy;
        if(y<=lowerBound) {
            y=lowerBound;
            speedy= Math.abs(speedy);
        }
        if(y>=upperBound) {
            y = upperBound;
            speedy = -Math.abs(speedy);
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

    public float getSpeedy() {
        return speedy;
    }

    public void setSpeedy(float speedy) {
        this.speedy = speedy;
    }

    public float getSpeedx() {
        return speedx;
    }

    public void setSpeedx(float speedx) {
        this.speedx = speedx;
    }

    public float getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(float lowerBound) {
        this.lowerBound = lowerBound;
    }

    public float getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(float upperBound) {
        this.upperBound = upperBound;
    }
}
