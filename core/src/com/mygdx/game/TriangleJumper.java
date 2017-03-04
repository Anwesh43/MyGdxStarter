package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by anweshmishra on 04/03/17.
 */
public class TriangleJumper extends ApplicationAdapter {
    private Sprite sprite;
    private int w,h;
    private Texture texture;
    private SpriteBatch spriteBatch;
    private int background_red = 0,background_green = 0,background_blue= 0,background_alpha = 0;
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(background_red,background_green,background_blue,background_alpha);
        spriteBatch.begin();
        sprite.draw(spriteBatch);
        spriteBatch.end();
    }
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        Pixmap pixmap = new Pixmap(w/4,w/4, Pixmap.Format.RGB888);
        pixmap.setColor(background_red,background_green,background_blue,background_alpha);
        Texture texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        spriteBatch = new SpriteBatch();
        pixmap.dispose();
    }
    public void dispose() {
        texture.dispose();
        spriteBatch.dispose();
    }
}
