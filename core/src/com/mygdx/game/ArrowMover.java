package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.Arrow;
import com.mygdx.game.objects.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 04/09/16.
 */
public class ArrowMover extends ApplicationAdapter{
    private Texture texture;
    private Sprite sprite;
    private SpriteBatch batch;
    private int w,h;
    private Arrow currentArrow;
    float currentDeg = 0;
    private List<Arrow> arrows = new ArrayList<Arrow>();
    boolean isDown;
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        Pixmap pixmap = new Pixmap(w/10,w/10, Pixmap.Format.RGB888);
        pixmap.setColor(0.25f,0.24f,0.16f,1.0f);
        pixmap.fill();
        pixmap.setColor(0.35f,0.43f,0.56f,1.0f);
        currentArrow = new Arrow(new Point(0,0),new Point(0,w/10),0);
        pixmap.drawLine((int)currentArrow.getTip().x,(int)currentArrow.getTip().y,(int)currentArrow.getEnd().x,(int)currentArrow.getEnd().y);
        pixmap.drawLine((int)currentArrow.getEnd().x,(int)currentArrow.getEnd().y,(int)currentArrow.getEnd().x-w/40,(int)currentArrow.getEnd().y-w/40);
        pixmap.drawLine((int)currentArrow.getEnd().x,(int)currentArrow.getEnd().y,(int)currentArrow.getEnd().x+w/40,(int)currentArrow.getEnd().y-w/40);
        texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        batch = new SpriteBatch();
        pixmap.dispose();
        //arrows.add(currentArrow);
        Gdx.input.setInputProcessor(new InputProcessorAdapter() {
           public boolean touchDown(int x,int y,int pntrt,int btn) {
               if(x<w/2) {
                   currentDeg = -90;
               }
               if(x>w/2) {
                   currentDeg = 90;
               }
               return true;
           }
        });
    }
    public void render() {
        Gdx.gl.glClearColor(0.25f,0.24f,0.16f,1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        sprite.draw(batch);
        sprite.setPosition(w/2,h/2);
        sprite.setRotation(currentArrow.getDeg());
        currentArrow.rotate(currentDeg);
        if(currentDeg!=0 && currentArrow.getDeg() == currentDeg) {
            arrows.add(currentArrow);
            currentDeg = 0;
            currentArrow = new Arrow(new Point(0,0),new Point(0,w/10),0);
        }
        for(Arrow arrow:arrows) {
            sprite.draw(batch);
            sprite.setPosition(w/2+arrow.getPivotx(),h/2);
            sprite.setRotation(arrow.getDeg());
            arrow.move(10*(Math.abs(arrow.getDeg())/arrow.getDeg()),0);
        }
        batch.end();
    }
    public void dispose() {
        texture.dispose();
        batch.dispose();
        arrows = null;
        currentArrow = null;
    }
}
