package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.CircularCone;

/**
 * Created by anweshmishra on 07/03/17.
 */
public class CircularConeRunner extends ApplicationAdapter {
    private Sprite sprite;
    private SpriteBatch batch;
    private int w,h;
    private Texture texture;
    private CircularCone circularCone;
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0,0,0,1);
        batch.begin();
        circularCone.render(sprite,batch);
        batch.end();
    }
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        circularCone = new CircularCone(w,h);
        Pixmap pixmap = new Pixmap(w/3,w/3, Pixmap.Format.RGB888);
        pixmap.setColor(Color.BLACK);
        pixmap.fill();
        circularCone.draw(pixmap);
        texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        batch = new SpriteBatch();
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
           public boolean touchDown(int x,int y,int btn,int pntr) {
               if(circularCone.getX()>x) {
                   circularCone.setDir(-1);
               }
               else {
                   circularCone.setDir(1);
               }
               return true;
           }
        });
        pixmap.dispose();
    }
    public void dispose() {
        texture.dispose();
        batch.dispose();
    }
}
