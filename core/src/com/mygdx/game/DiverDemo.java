package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.Diver;
import com.mygdx.game.utils.DrawUtil;

/**
 * Created by anweshmishra on 30/10/16.
 */
public class DiverDemo extends ApplicationAdapter {
    private SpriteBatch batch;
    private Sprite sprite;
    private int scale[] = {1,-1};
    private Diver diver;
    private int currentScale = 1,index = 0;

    private Texture texture;
    private int w,h;
    public void render() {
        Gdx.gl20.glClearColor(0,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        sprite.draw(batch);
        sprite.setScale(currentScale,1);
        sprite.setRotation(diver.getDeg());
        sprite.setPosition(diver.getX(),diver.getY());
        diver.move();
        batch.end();
    }
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        diver = new Diver(0,h/2,w);
        batch = new SpriteBatch();
        Pixmap pixmap = new Pixmap(w/10,w/10, Pixmap.Format.RGB888);
        DrawUtil.drawDiver(pixmap,w/20,w/20,w/20);
        texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        pixmap.dispose();
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
           public boolean touchDown(int x,int y,int btn,int pntr) {
               diver.toggleDir();
               index++;
               currentScale = scale[index%2];
               return true;
           }
        });
    }
    public void dispose() {
        texture.dispose();
        batch.dispose();
        diver = null;
    }
}
