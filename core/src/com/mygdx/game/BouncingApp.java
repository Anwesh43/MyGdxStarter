package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.Rounder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 13/10/16.
 */
public class BouncingApp extends ApplicationAdapter {
    private SpriteBatch batch;
    private Sprite sprite;
    private Texture texture;
    private int w,h;
    private List<Rounder> rounders = new ArrayList<Rounder>();
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        batch = new SpriteBatch();
        Pixmap pixmap = new Pixmap(w/10,w/10, Pixmap.Format.RGB888);
        pixmap.setColor(Color.BLACK);
        pixmap.fill();
        pixmap.setColor(Color.GREEN);
        pixmap.fillCircle(w/20,w/20,w/20);
        texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        rounders.add(new Rounder(w/10,h/2));
        pixmap.dispose();
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
            public boolean touchDown(int x,int y,int pntr,int btn) {
                if(rounders.size()>0) {
                    rounders.get(rounders.size()-1).setRot(10);
                }
                rounders.add(new Rounder(w/10,h/2));
                return true;
            }
        });
    }
    public void render() {
        Gdx.gl20.glClearColor(0,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        for(Rounder rounder:rounders) {
            sprite.setScale(rounder.getScale());
            sprite.setPosition(rounder.getX(),rounder.getY());
            sprite.draw(batch);
            rounder.move();
        }
        batch.end();
    }
    public void dispose() {
        texture.dispose();
        batch.dispose();
    }
}
