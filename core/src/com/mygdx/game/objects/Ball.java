package com.mygdx.game.objects;

/**
 * Created by anweshmishra on 02/09/16.
 */
public class Ball {
    public Ball(float x,float y,float direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
    private float x,y,direction;
    public void setX(float x){
        this.x = x;
    }
    public void move() {
        this.x+=this.direction*10;
    }
    public void setY(float y) {
        this.y = y;
    }
    public void setDirection(float direction){
        this.direction = direction;
    }
    public float getDirection() {
        return direction;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public boolean equals(Object object) {
        Ball ball =  ((Ball)object);
        return ball.getX() == x && ball.getY() == y && ball.getDirection() == direction;
    }
    public int hashCode() {
        return  (int)(x*x+y*y+direction+2*x-2*y);
    }
}
