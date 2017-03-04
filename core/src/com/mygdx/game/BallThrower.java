package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.MovingBall;
import com.mygdx.game.objects.Rotator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 26/09/16.
 */
public class BallThrower extends ApplicationAdapter{
    private Sprite ballSprite,hitSprite;
    private SpriteBatch batch;
    private List<MovingBall> balls = new ArrayList<MovingBall>();
    private Rotator rotator;
    private Texture ballTexture,hitTexture;
    private int w,h;
    public void render() {
        Gdx.gl20.glClearColor(0,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        hitSprite.draw(batch);
        rotator.move();
        hitSprite.setRotation(rotator.getDeg()+90);
        for(MovingBall ball:balls) {
            ballSprite.setPosition(ball.getX(),ball.getY());
            ballSprite.draw(batch);
            ball.move();
        }
        batch.end();
    }
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        batch = new SpriteBatch();
        Pixmap ballPixmap = new Pixmap(w/10,w/10, Pixmap.Format.RGB888);
        Pixmap hitPixmap = new Pixmap(2*w/5,w/10, Pixmap.Format.RGB888);
        hitPixmap.setColor(Color.BLACK);
        hitPixmap.fill();
        hitPixmap.setColor(Color.GREEN);
        hitPixmap.drawLine(0,0,2*w/5,0);

        ballPixmap.setColor(Color.BLACK);
        ballPixmap.fill();
        ballPixmap.setColor(Color.GREEN);
        ballPixmap.fillCircle(w/20,w/20,w/20);
        hitTexture = new Texture(hitPixmap);
        ballTexture = new Texture(ballPixmap);
        hitSprite = new Sprite(hitTexture);
        hitSprite.setPosition(w/2,-w/5);
        ballSprite = new Sprite(ballTexture);
        rotator = new Rotator(3*w/20,0);
        ballPixmap.dispose();
        hitPixmap.dispose();
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
            public boolean touchDown(int x,int y,int pntr,int btn) {
                MovingBall ball = new MovingBall(w/2+rotator.decideX(),rotator.decideY(),w/20,0,10);
                balls.add(ball);
                return true;
            }
        });
    }
    public void dispose() {
        ballTexture.dispose();
        hitTexture.dispose();
        batch.dispose();
    }
}
