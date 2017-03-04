package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.Nipper;
import com.mygdx.game.utils.DrawUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by anweshmishra on 03/11/16.
 */
public class NipperDemo extends ApplicationAdapter {

    private Texture texture;
    private SpriteBatch batch;
    private Sprite sprite;
    private int w,h;
    private ConcurrentLinkedQueue<Nipper> nippers = new ConcurrentLinkedQueue<Nipper>();
    public void render() {
        Gdx.gl20.glClearColor(1,1,1,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        for(Nipper nipper:nippers) {
            sprite.draw(batch);
            sprite.setPosition(nipper.getX(),nipper.getY());
            sprite.setRotation(nipper.getDeg());
            nipper.move();
            if(nipper.isOverBoundary()) {
                nippers.remove(nipper);
            }
        }
        batch.end();
    }
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        batch = new SpriteBatch();
        Pixmap pixmap = new Pixmap(h/10,h/10, Pixmap.Format.RGB888);
        DrawUtil.drawNipper(pixmap,h/10,h/10);
        texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        pixmap.dispose();
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
            public boolean touchDown(int x,int y,int btn,int pntr) {
                nippers.add(new Nipper(x,h-y,h));
                return true;
            }
        });
    }
    public void dispose() {
        texture.dispose();
        batch.dispose();
        nippers = null;
    }
}
