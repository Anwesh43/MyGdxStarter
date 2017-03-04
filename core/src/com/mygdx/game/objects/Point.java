package com.mygdx.game.objects;

/**
 * Created by anweshmishra on 03/09/16.
 */
public class Point {
    public float x,y;
    public Point(float x,float y) {
        this.x = x;
        this.y = y;
    }
    public boolean equals(Object object) {
        Point point = (Point)object;
        return point.x == x && point.y == y;
    }
    public int hashCode() {
        return (int)(x*x+y*y+x-y);
    }
}
