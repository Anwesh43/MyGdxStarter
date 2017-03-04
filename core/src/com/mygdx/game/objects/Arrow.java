package com.mygdx.game.objects;

/**
 * Created by anweshmishra on 04/09/16.
 */
public class Arrow {
    private Point tip;
    private Point end;
    private float deg,pivotx;
    public Arrow(Point tip,Point end,float deg) {
        this.tip = tip;
        this.end = end;
        this.deg = deg;
    }
    public void setDeg(float deg) {
        this.deg = deg;
    }
    public float getDeg() {
        return deg;
    }
    public void setTip(Point tip) {
        this.tip = tip;
    }
    public Point getTip() {
        return tip;
    }
    public Point getEnd(){
        return end;
    }
    public void setEnd(Point end) {
        this.end = end;
    }

    public float getPivotx() {
        return pivotx;
    }

    public void setPivotx(float pivotx) {
        this.pivotx = pivotx;
    }

    public void move(float speedx, float speedy) {
        pivotx+=speedx;


    }
    public void rotate(float finalDeg){
        if(finalDeg!=0) {
            float direction = Math.abs(finalDeg)/finalDeg;
            if(Math.abs(deg)<Math.abs(finalDeg)) {
                deg+=direction*10;
            }
        }
    }
    public boolean equals(Object o) {
        Arrow arrow = (Arrow)o;
        return arrow.getTip() == tip && deg == arrow.deg && end == arrow.getEnd();
    }
    public int hashCode() {
        return (tip.hashCode())+(end.hashCode())+(int)deg;
    }
}
