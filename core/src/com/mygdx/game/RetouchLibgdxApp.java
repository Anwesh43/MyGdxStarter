package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by anweshmishra on 03/03/17.
 */
public class RetouchLibgdxApp extends ApplicationAdapter {
    private Texture texture;
    private Sprite sprite;
    private int w,h;
    private float deg = 0,dir = 1;
    private SpriteBatch spriteBatch;
    public void render() {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.begin();
        sprite.setPosition(w/2,h/2);
        sprite.setRotation(deg);
        sprite.draw(spriteBatch);
        spriteBatch.end();
        deg+=5*dir;
        if(deg%90 == 0 && dir == 1){
            dir = 0;
        }
    }
    public void create() {
        w  = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        Pixmap pixmap = new Pixmap(w/4,w/4, Pixmap.Format.RGB888);
        pixmap.fill();
        pixmap.setColor(Color.GREEN);
        pixmap.fillRectangle(0,0,w/4,w/4);
        pixmap.setColor(Color.RED);
        pixmap.fillCircle(w/8,w/8,w/32);
        texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        spriteBatch = new SpriteBatch();
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
            public boolean touchDown(int x,int y,int pntr,int btn) {
                dir = dir == 0?1:0;
                return true;
            }
        });
        pixmap.dispose();
    }
    public void dispose() {
        texture.dispose();
        spriteBatch.dispose();
    }
}
