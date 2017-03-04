package com.mygdx.game.objects;

import com.badlogic.gdx.physics.box2d.CircleShape;

/**
 * Created by anweshmishra on 28/09/16.
 */
public class CirclePath {
    private float x,y;
    private CirclePath neighbor0,neighbor1,neighbor2,neighbor3;
    private boolean visited= false;

    public CirclePath getNeighbor0() {
        return neighbor0;
    }

    public void setNeighbor0(CirclePath neighbor0) {
        this.neighbor0 = neighbor0;
    }

    public CirclePath getNeighbor1() {
        return neighbor1;
    }

    public void setNeighbor1(CirclePath neighbor1) {
        this.neighbor1 = neighbor1;
    }

    public CirclePath getNeighbor2() {
        return neighbor2;
    }

    public void setNeighbor2(CirclePath neighbor2) {
        this.neighbor2 = neighbor2;
    }

    public CirclePath getNeighbor3() {
        return neighbor3;
    }

    public void setNeighbor3(CirclePath neighbor3) {
        this.neighbor3 = neighbor3;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public CirclePath(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public void setX(float x){
        this.x = x;
    }
    public float setY(float y) {
        return y;
    }
    public void addNeighbor0(CirclePath circlePath) {
        neighbor0 = circlePath;
    }
    public void addNeighbor1(CirclePath circlePath) {
        neighbor1 = circlePath;
    }
    public void addNeighbor2(CirclePath circlePath) {
        neighbor2 = circlePath;
    }
    public void addNeighbor3(CirclePath circlePath) {
        neighbor3 = circlePath;
    }
}
