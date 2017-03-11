package com.mygdx.game.objects;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by anweshmishra on 11/03/17.
 */
public class CurpBall {
    private float x=0,y = 0,deg = 0,dir=1,w;
    private CurpBall(float y,float w) {
        this.y = y;
        this.w = w;
    }
    public static CurpBall getInstance(float y,float w) {
        return new CurpBall(y,w);
    }
    private Pixmap getHalfPixmap(Pixmap pixmap) {
        return new Pixmap(pixmap.getWidth(),pixmap.getHeight()/2, Pixmap.Format.RGB888);

    }
    public void toggleMovement() {
        dir = dir==0?1:0;
    }
    public void draw(Pixmap pixmap,Color backcolor) {
        Pixmap firstHalfPixmap = getHalfPixmap(pixmap);
        Pixmap secondHalfPixmap = getHalfPixmap(pixmap);
        firstHalfPixmap.setColor(backcolor);
        firstHalfPixmap.fill();
        firstHalfPixmap.setColor(244.0f/255,67.0f/255,54.0f/255,1);
        firstHalfPixmap.fillCircle(firstHalfPixmap.getWidth()/2,firstHalfPixmap.getHeight(),firstHalfPixmap.getWidth()/2);
        secondHalfPixmap.setColor(backcolor);
        secondHalfPixmap.fill();
        secondHalfPixmap.setColor(245.0f/255.0f,245.0f/255,245.0f/255,1);
        secondHalfPixmap.fillCircle(secondHalfPixmap.getWidth()/2,0,secondHalfPixmap.getWidth()/2);
        pixmap.setColor(244.0f/255,67.0f/255,54.0f/255,1);
        pixmap.drawPixmap(firstHalfPixmap,0,0);
        pixmap.setColor(245.0f/255.0f,245.0f/255,245.0f/255,1);
        pixmap.drawPixmap(secondHalfPixmap,0,pixmap.getHeight()/2);
        pixmap.setColor(245.0f/255.0f,245.0f/255,245.0f/255,1);
        pixmap.drawCircle(pixmap.getWidth()/2,pixmap.getHeight()/2,pixmap.getWidth()/15);
        pixmap.setColor(Color.BLACK);
        pixmap.fillCircle(pixmap.getWidth()/2,pixmap.getHeight()/2,pixmap.getWidth()/15);
        pixmap.drawLine(0,pixmap.getHeight()/2,pixmap.getWidth()/2-pixmap.getWidth()/15,pixmap.getHeight()/2);
        pixmap.drawLine(pixmap.getWidth()/2+pixmap.getWidth()/15,pixmap.getHeight()/2,pixmap.getWidth(),pixmap.getHeight()/2);
        pixmap.setColor(245.0f/255.0f,245.0f/255,245.0f/255,1);
        pixmap.fillCircle(pixmap.getWidth()/2,pixmap.getHeight()/2,pixmap.getWidth()/20);
    }
    private void update() {
        deg+=dir*5;
        x+=dir*5;
        if(x>=w) {
            x = 0;
        }
    }
    public void render(SpriteBatch spriteBatch, Sprite sprite) {
        update();
        sprite.setPosition(x,y);
        sprite.setRotation(deg);
        sprite.draw(spriteBatch);
    }
}
