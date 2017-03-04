package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.SquareContainBall;

/**
 * Created by anweshmishra on 15/10/16.
 */
public class SquareRun extends ApplicationAdapter {
    private Sprite sprite;
    private SpriteBatch batch;
    private Texture texture;
    private SquareContainBall ball;
    private int w,h;
    public void render() {
        Gdx.gl20.glClearColor(0,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        sprite.draw(batch);
        sprite.setPosition(ball.getX(),ball.getY());
        ball.move();
        batch.end();
    }
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        batch = new SpriteBatch();
        Pixmap pixmap = new Pixmap(w/10,w/10, Pixmap.Format.RGB888);
        pixmap.setColor(Color.GREEN);
        pixmap.fillCircle(w/20,w/20,w/20);
        texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        batch = new SpriteBatch();
        pixmap.dispose();
        ball = new SquareContainBall(w/2,0,h/10,h);
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
            public boolean touchDown(int x,int y,int pntr,int btn) {
                ball.changeToSquareMode();
                return true;
            }
        });

    }
    public void dispose() {
        texture.dispose();
        batch.dispose();
        ball = null;
    }

}
