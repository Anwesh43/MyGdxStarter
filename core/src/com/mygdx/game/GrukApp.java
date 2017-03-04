package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.GrukBall;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 08/10/16.
 */
public class GrukApp extends ApplicationAdapter{
    private Sprite ballSprite;
    private int w,h;
    private Texture ballTexture;
    private SpriteBatch batch;
    private GrukBall currentBall;
    private List<GrukBall> grukBalls = new ArrayList<GrukBall>();
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        currentBall = new GrukBall(w/2,h/2,h/5);
        Pixmap pixmap = new Pixmap(h/10,h/10, Pixmap.Format.RGB888);
        pixmap.setColor(0,0,0,1);
        pixmap.fill();
        pixmap.setColor(3,155,229 ,1);
        pixmap.fillCircle(h/20,h/20,h/20);
        ballTexture = new Texture(pixmap);
        ballSprite = new Sprite(ballTexture);
        batch = new SpriteBatch();
        pixmap.dispose();;
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
            public boolean touchDown(int x,int y,int pntr,int btn) {
                currentBall.changeMode();
                grukBalls.add(currentBall);
                currentBall = new GrukBall(w/2,h/2,w/5);
                return true;
            }
        });
    }
    public void render() {
        Gdx.gl20.glClearColor(0,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        ballSprite.setPosition(currentBall.getX(),currentBall.getY());
        currentBall.move();
        ballSprite.draw(batch);
        for(GrukBall ball:grukBalls) {
            ballSprite.setPosition(ball.getX(),ball.getY());
            ball.move();
            ballSprite.draw(batch);
        }
        batch.end();
    }
    public void dispose() {
        ballTexture.dispose();
        batch.dispose();
        currentBall = null;
        grukBalls = null;

    }
    public void resize(int w,int h) {

    }
}
