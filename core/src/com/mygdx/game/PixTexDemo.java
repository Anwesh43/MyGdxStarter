package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by anweshmishra on 26/08/16.
 */
public class PixTexDemo extends ApplicationAdapter {
    private Pixmap pixmap;
    private SpriteBatch batch;
    private Texture texture;
    private Sprite sprite;
    private float deg;
    public void resize(int w,int h) {

    }
    public void render() {
        Gdx.gl.glClearColor(56.0f/255,142.0f/255,60.0f/255 ,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        sprite.draw(batch);
        sprite.rotate(deg);
        sprite.setX(Gdx.graphics.getWidth()/2);
        sprite.setY(Gdx.graphics.getHeight()/2);
        batch.end();
    }
    public void create() {
        int w = Gdx.graphics.getWidth(),h = Gdx.graphics.getHeight();
        Gdx.app.debug("width,height of app",w+","+h);
        batch = new SpriteBatch();
        Pixmap pixmap = new Pixmap(w/10,w/10, Pixmap.Format.RGB888);
        pixmap.setColor(56.0f/255,142.0f/255,60.0f/255 ,1);
        pixmap.fill();

        pixmap.setColor(149.0f/255,117.0f/255,205.0f/255 ,1);
        pixmap.fillTriangle(0,w/10,w/10,w/10,w/20,0);
        texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        pixmap.dispose();
        deg = 1.5f*(float)Math.PI;
    }
    public void pause() {
    }
}
