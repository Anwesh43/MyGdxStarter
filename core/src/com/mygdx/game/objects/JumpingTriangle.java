package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by anweshmishra on 04/03/17.
 */
public class JumpingTriangle {
    private float x,y,deg=0,initY;
    private int dir = 1;
    public JumpingTriangle(float x,float y) {
        this.x = x;
        this.y = y;
        this.initY = y;
    }
    public void draw(Pixmap pixmap) {
        pixmap.setColor(Color.ORANGE);
        pixmap.fillTriangle(0,pixmap.getHeight(),pixmap.getWidth(),pixmap.getHeight(),pixmap.getWidth()/2,0);
    }
    private void move() {
        x+=10;
        y+=20*dir;
        deg+=20*dir;
        if(y<=initY-180) {
            dir = -1;
        }
        if(y>=initY) {
            y = initY;
            dir = 0;
            deg = 0;
        }


    }
    public void jump() {
        if(dir == 0) {
            dir = 1;
        }
    }
    public void update(Sprite sprite) {
        move();
        sprite.setPosition(x,y);
        sprite.setRotation(deg);
    }
}
