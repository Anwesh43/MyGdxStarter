package com.mygdx.game.objects;

/**
 * Created by anweshmishra on 26/09/16.
 */
public class MovingBall {
    private float x,y,radius,dx,dy;
    public MovingBall(float x,float y,float radius,float dx,float dy) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.dx = dx;
        this.dy = dy;
    }
    public void move() {
        this.x+=dx;
        this.y+=dy;
    }
    public int hashCode() {
        return (int)x+(int)y+(int)radius+(int)dx+(int)dy;
    }
    public boolean equals(Object object) {
        MovingBall ball = (MovingBall)object;
        return ball.hashCode() == hashCode();
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }
}
