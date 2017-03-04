package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;

/**
 * Created by anweshmishra on 26/08/16.
 */
public class TextSpriteDemo extends ApplicationAdapter{
    private Texture texture;
    private Sprite sprite;
    private SpriteBatch batch;
    private float deg;
    public void render() {
        Gdx.gl.glClearColor(0,137.0f/255,123.0f/255 ,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        sprite.draw(batch);
        sprite.setX(Gdx.graphics.getWidth()/2);
        sprite.setY(Gdx.graphics.getHeight()/2);
        Gdx.app.log("x,y",sprite.getX()+","+sprite.getY());
        sprite.rotate(deg);
        batch.end();

    }
    public void create() {
        batch = new SpriteBatch();
        texture = new Texture("badlogic.jpg");
        sprite = new Sprite(texture);
        deg = (float)Math.PI/3;
    }
    public void resize(int w,int h){

    }
    public void dispose() {
        texture.dispose();
        batch.dispose();

    }
}
