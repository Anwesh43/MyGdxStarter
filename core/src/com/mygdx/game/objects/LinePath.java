package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;

/**
 * Created by anweshmishra on 24/09/16.
 */
public class LinePath{
    private Point pivot,endpoint;

    public LinePath(Point pivot) {
        this.pivot = pivot;
        this.endpoint = pivot;
    }
    public void setPivot(Point pivot) {
        this.pivot = pivot;
    }
    public void setEndpoint(Point endpoint) {
        this.endpoint = endpoint;
    }
    public void draw(Pixmap pixmap) {
        pixmap.drawLine((int)pivot.x,(int)pivot.y,(int)endpoint.x,(int)endpoint.y);
    }
    public boolean contains(VertexBall ball) {
        return endpoint.x>=ball.getCenter().x-ball.getRadius() && endpoint.x<=ball.getCenter().x+ball.getRadius() && endpoint.y>=ball.getCenter().y-ball.getRadius() && endpoint.y<=ball.getCenter().y+ball.getRadius();
    }
    public boolean equals(Object object) {
        return ((LinePath)object).hashCode() == hashCode();
    }
    public int hashCode() {
        return pivot.hashCode()+endpoint.hashCode();
    }
}
