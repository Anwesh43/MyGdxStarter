package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.Clock;
import com.mygdx.game.utils.DrawUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import javafx.scene.paint.Color;

/**
 * Created by anweshmishra on 24/10/16.
 */
public class ClockDemo extends ApplicationAdapter {
    private SpriteBatch batch;
    private Sprite sprite;
    private Texture texture;
    private int w,h;
    private ConcurrentLinkedQueue<Clock> clocks = new ConcurrentLinkedQueue<Clock>();
    public void render() {
        Gdx.gl20.glClearColor(0,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        //sprite.draw(batch);
        for(Clock clock:clocks) {

            sprite.setPosition(clock.getX(),clock.getY());
            sprite.setRotation(clock.getDeg());
            clock.move();
            sprite.draw(batch);

            if(clock.isRotated()) {
                clocks.remove(clock);
            }
        }
        batch.end();
    }
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        batch = new SpriteBatch();
        Pixmap pixmap = new Pixmap(w/10,w/10, Pixmap.Format.RGB888);
        DrawUtil.drawClock(pixmap,w/20,w/20,w/20);
        texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        pixmap.dispose();
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
            public boolean touchDown(int x,int y,int btn,int pointer) {
                clocks.add(new Clock(x,h-y));
                return true;
            }
        });
    }

    public void dispose() {
        texture.dispose();
        batch.dispose();
        clocks = null;
    }
    public void resize(int w,int h) {

    }
}
