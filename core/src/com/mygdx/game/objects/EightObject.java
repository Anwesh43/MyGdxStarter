package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by anweshmishra on 06/03/17.
 */
public class EightObject {
    private float x=0,y,w,dir = 0,deg=0;
    public EightObject(float y,float w) {
        this.y = y;
        this.w = w;
    }
    public void draw(Pixmap pixmap,int w,int h) {
        pixmap.fill();
        pixmap.setColor(Color.ORANGE);
        pixmap.drawCircle(w/2,h/4,w/2);
        pixmap.drawCircle(w/2,h/2+h/4,w/2);
    }
    public void start() {
        dir = dir == 0?1:0;
    }
    private void update() {
        x+=dir*5;
        deg+=dir*5;
    }
    public void render(Sprite sprite, SpriteBatch batch) {
        update();
        sprite.setPosition(x,y);
        sprite.setRotation(deg);
        sprite.draw(batch);
    }

}
