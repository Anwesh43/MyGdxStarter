package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.ToucheBall;

/**
 * Created by anweshmishra on 14/10/16.
 */
public class TouchToRot extends ApplicationAdapter{
    private Sprite ballSprite;
    private SpriteBatch batch;
    private Texture ballTexture;
    private int w,h;
    private ToucheBall ball;
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        batch = new SpriteBatch();
        Pixmap ballPixmap = new Pixmap(w/16,w/16, Pixmap.Format.RGB888);
        ballPixmap.setColor(Color.BLACK);
        ballPixmap.fill();
        ballPixmap.setColor(Color.GREEN);
        ballPixmap.fillCircle(w/40,w/40,w/40);
        ballTexture = new Texture(ballPixmap);
        ballSprite = new Sprite(ballTexture);
        ball = new ToucheBall(w/2,0,h/10,h);
        ballPixmap.dispose();
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
            public boolean touchDown(int x,int y,int btn,int pntr) {
                ball.setCircularMotion();
                return true;
            }
        });
    }
    public void render() {
        Gdx.gl20.glClearColor(0,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        ballSprite.draw(batch);
        ballSprite.setPosition(ball.getX(),ball.getY());
        ball.move();
        batch.end();
    }
    public void dispose() {
        batch.dispose();
        ballTexture.dispose();
    }
}
