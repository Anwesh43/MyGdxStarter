package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.objects.Bouncer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 12/10/16.
 */
public class SomeRandomApp extends ApplicationAdapter {
    private SpriteBatch batch;
    private Sprite currentSprite;
    private Texture currentTexture;
    private int w,h;
    private List<Bouncer> bouncers = new ArrayList<Bouncer>();
    public void render() {
        Gdx.gl20.glClearColor(0,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        for(Bouncer bouncer:bouncers) {
            currentSprite.draw(batch);
            currentSprite.setScale(bouncer.getScaleVector().x,bouncer.getScaleVector().y);
            currentSprite.setPosition(bouncer.getPoint().x,bouncer.getPoint().y);
            bouncer.move();
        }
        batch.end();
    }
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        Pixmap pixmap = new Pixmap(w/10,w/10, Pixmap.Format.RGB888);
        pixmap.setColor(Color.BLACK);
        pixmap.fill();
        pixmap.setColor(Color.ORANGE);
        pixmap.fillCircle(w/20,w/20,w/20);
        currentTexture = new Texture(pixmap);
        currentSprite = new Sprite(currentTexture);
        batch = new SpriteBatch();
        pixmap.dispose();
        bouncers.add(new Bouncer(new Vector2(0,h/2),h));
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
            public boolean touchDown(int x,int y,int pntr,int btn) {
                Bouncer recentBouncer = bouncers.get(bouncers.size()-1);
                y = h-y;
                float sx = 10;
                float sy = sx*(y-recentBouncer.getPoint().y)/(x-recentBouncer.getPoint().x);
                if(recentBouncer.getMode() == 1) {
                    recentBouncer.setSpeed(new Vector2(sx, sy));
                    bouncers.add(new Bouncer(new Vector2(0, h / 2), h));
                }
                return true;
            }
        });
    }
    public void dispose() {
        currentTexture.dispose();
        batch.dispose();
    }
}
