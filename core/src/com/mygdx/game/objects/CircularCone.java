package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by anweshmishra on 07/03/17.
 */
public class CircularCone {
    private float x,y,deg=0,w = 100,h = 100,dir = -1;
    public CircularCone(float w,float h) {
        this.w = w;
        this.x = 0;
        this.y = h/2;
    }
    public float getX() {
        return x;
    }
    public void draw(Pixmap pixmap) {
        pixmap.setColor(Color.ORANGE);
        pixmap.fillCircle(pixmap.getWidth()/2,pixmap.getHeight()/2,pixmap.getWidth()/4);
        pixmap.fillTriangle(pixmap.getWidth()/2,pixmap.getHeight()/2-pixmap.getWidth()/4,0,0,pixmap.getWidth(),0);
    }
    private void update() {
        x+=dir*10;
        if(Math.abs(deg)<90) {
            deg-=10*dir;
        }
        if(x<-w/6) {
            x = w-w/6;
        }
        if(x>w) {
            x = 0;
        }
    }
    public void setDir(float dir) {
        this.dir = dir;
        deg-=10*dir;
    }
    public void render(Sprite sprite, SpriteBatch spriteBatch) {
        update();
        sprite.setPosition(x,y);
        sprite.setRotation(deg);
        sprite.draw(spriteBatch);
    }
}
