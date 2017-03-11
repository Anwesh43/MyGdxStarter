package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.CurpBall;

/**
 * Created by anweshmishra on 11/03/17.
 */
public class CurpBallRunner extends ApplicationAdapter {
    private Texture texture;
    private Sprite sprite;
    private int w,h;
    private CurpBall curpBall;
    private SpriteBatch spriteBatch;
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0,0,0,1);
        spriteBatch.begin();
        curpBall.render(spriteBatch,sprite);
        spriteBatch.end();
    }
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        curpBall = CurpBall.getInstance(h/2,w);
        Pixmap pixmap = new Pixmap(w/8,w/8, Pixmap.Format.RGB888);
        pixmap.setColor(0,0,0,1);
        pixmap.fill();
        curpBall.draw(pixmap, Color.BLACK);
        texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        spriteBatch = new SpriteBatch();
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
            public boolean touchDown(int x,int y,int pntr,int btn) {
                curpBall.toggleMovement();
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
