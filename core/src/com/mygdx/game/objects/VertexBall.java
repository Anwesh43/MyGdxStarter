package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;

/**
 * Created by anweshmishra on 24/09/16.
 */
public class VertexBall {
    private Point center;
    private int radius;
    public VertexBall(Point center,int radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    public void draw(Pixmap pixmap) {
        pixmap.fillCircle((int)center.x,(int)center.y,radius);
    }
    public int hashCode() {
        return center.hashCode()+radius;
    }
    public boolean equals(Object object) {
        return ((VertexBall)object).hashCode() == hashCode();
    }
}
