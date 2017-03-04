package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.Dumble;
import com.mygdx.game.objects.MovingBall;
import com.mygdx.game.utils.DrawUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by anweshmishra on 29/10/16.
 */
public class DumbleDemo extends ApplicationAdapter {
    private Sprite sprite;
    private Texture texture;
    private SpriteBatch batch;
    private int w,h;
    private Dumble currentDumble;
    private boolean isDown = false;
    private ConcurrentLinkedQueue<Dumble> dumbles = new ConcurrentLinkedQueue<Dumble>();
    public void create() {
        batch = new SpriteBatch();
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        Pixmap pixmap = new Pixmap(w/4,w/4, Pixmap.Format.RGB888);
        DrawUtil.drawDumble(pixmap,w/8,w/8,w/8);
        final Dumble dumble = new Dumble(w/8,w/8,w/8,w/8);
        dumbles.add(dumble);
        texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        batch = new SpriteBatch();
        pixmap.dispose();
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
            public boolean touchDown(int x,int y,int pntr,int btn) {

                if(dumbles.size()>0 && dumbles.peek().contains(x,h-y) && !isDown) {
                    isDown = true;
                    Dumble prevDumble = dumbles.peek();
                    currentDumble = new Dumble(prevDumble.getX(),prevDumble.getY(),w/8,w/8);
                    dumbles.add(currentDumble);
                }
                return true;
            }
            public boolean touchDragged(int x,int y,int pntr) {
                if(isDown) {
                    currentDumble.moveXY(x,h-y);
                }
                return true;
            }
            public boolean touchUp(int x,int y,int pntr,int btn) {
                if(isDown) {
                    isDown = false;
                }
                return true;
            }
        });
    }
    public void render() {
        Gdx.gl20.glClearColor(0,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        for(Dumble dumble:dumbles) {
            sprite.draw(batch);
            sprite.setPosition(dumble.getX(),dumble.getY());
            sprite.setRotation(dumble.getDeg());
            dumble.move();
        }
        batch.end();
    }
    public void dispose() {
        texture.dispose();
        batch.dispose();
        dumbles = null;
    }
    public void resize(int w,int h) {

    }
}
