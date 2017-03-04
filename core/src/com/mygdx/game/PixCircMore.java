package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 28/08/16.
 */
public class PixCircMore extends ApplicationAdapter {
    private SpriteBatch batch;
    private Sprite sprite;
    private Texture texture;
    private int w,h;
    private List<Body> bodyList = new ArrayList<Body>();
    public void render() {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        for(Body body:bodyList) {
            sprite.setPosition(body.getX(),body.getY());
            sprite.setRotation(body.getDeg());
            sprite.draw(batch);
            body.setDeg(body.getDeg()+(float) Math.PI/3);
        }
        batch.end();
    }
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        Pixmap pixmap = new Pixmap(w/10,w/10, Pixmap.Format.RGB888);
        pixmap.setColor(Color.CORAL);
        pixmap.fillRectangle(0,0,w/10,w/10);
        pixmap.setColor(Color.GREEN);
        pixmap.drawCircle(w/20,w/20,w/20);
        texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        batch = new SpriteBatch();
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
           public boolean touchDown(int x,int y,int pointer,int button) {
               bodyList.add(new Body(x,h-y,0));
               return true;
           }
        });
        pixmap.dispose();

    }
    public void resize(int w,int h) {

    }
    public void dispose() {
        texture.dispose();
        batch.dispose();
    }

}
