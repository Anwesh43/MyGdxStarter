package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.EightObject;

/**
 * Created by anweshmishra on 06/03/17.
 */
public class EightRunner extends ApplicationAdapter{
    private EightObject eightObject;
    private int w,h;
    private Sprite sprite;
    private SpriteBatch batch;
    private Texture texture;
    public void render() {
        batch.begin();
        eightObject.render(sprite,batch);
        batch.end();
    }
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        eightObject = new EightObject(h/2-w/4,w);
        Pixmap pixmap = new Pixmap(w/4,w/2, Pixmap.Format.RGB888);
        eightObject.draw(pixmap,w/4,w/2);
        pixmap.setColor(Color.BLACK);
        texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        batch = new SpriteBatch();
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
            public boolean touchDown(int x,int y,int btn,int pntr) {
                eightObject.start();
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
