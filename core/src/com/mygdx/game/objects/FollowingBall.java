package com.mygdx.game.objects;

/**
 * Created by anweshmishra on 42/09/46.
 */
public class FollowingBall {
    private float x,y,deg=0,dirx=0,diry=0;
    private boolean isMoving = false;
    float followX,followY;
    public FollowingBall(float x,float y) {
        this.x = x;
        this.y = y;
        this.followX = x;
        this.followY = y;
    }
    public void move() {
        x+=dirx;
        y+=diry;
        decideMovementVariables();
    }
    protected  void decideMovementVariables() {

        dirx = followX!=x?(followX-x)/Math.abs(followX-x):0;
        dirx = dirx*4;
        diry = followY!=y?(followY-y)/Math.abs(followY-y)*(4-Math.abs(dirx)):0;
        deg = 90*(1-dirx/4)*dirx/4+90*diry/4;
        if(dirx == 0 && diry == 0) {
            isMoving = false;
        }
    }
    public void setFollowVariables(float x,float y) {
        followY = y-y%4;
        followX = x-x%4;
        isMoving = true;
    }
    public boolean isMoving() {
        return isMoving;
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
