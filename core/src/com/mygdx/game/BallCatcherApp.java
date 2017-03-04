package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.Ball;
import com.mygdx.game.objects.StoppingLine;
import com.mygdx.game.objects.VerticalBall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by anweshmishra on 04/10/16.
 */
public class BallCatcherApp extends ApplicationAdapter{
    private ConcurrentLinkedQueue<VerticalBall> balls = new ConcurrentLinkedQueue<VerticalBall>();
    private ConcurrentLinkedQueue<StoppingLine> lines = new ConcurrentLinkedQueue<StoppingLine>();
    private Sprite ballSrpite,lineSprite;
    private SpriteBatch batch;
    private Texture ballTexture,lineTexture;
    private int w,h,time=0;
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        Pixmap ballPixmap = createBall();
        ballTexture = new Texture(ballPixmap);
        ballSrpite = new Sprite(ballTexture);
        ballPixmap.dispose();
        Pixmap linePixmap = createLine();
        lineTexture = new Texture(linePixmap);
        lineSprite = new Sprite(lineTexture);
        batch = new SpriteBatch();
        linePixmap.dispose();
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
           public boolean touchDown(int x,int y,int btn,int pointer) {
               lines.add(new StoppingLine(x,h-y,w/20));
               return true;
           }
        });

    }
    public Pixmap createLine() {
        Pixmap pixmap = new Pixmap(w/10,w/50, Pixmap.Format.RGB888);
        pixmap.setColor(Color.BLACK);
        pixmap.fill();
        pixmap.setColor(Color.WHITE);
        pixmap.drawLine(0,w/100,w/10,w/100);
        return pixmap;
    }
    public Pixmap createBall() {
        Pixmap pixmap = new Pixmap(w/10,w/10, Pixmap.Format.RGB888);
        pixmap.setColor(Color.BLACK);
        pixmap.fill();
        pixmap.setColor(Color.TEAL);
        pixmap.fillCircle(w/20,w/20,w/20);
        return pixmap;
    }
    public VerticalBall createVerticalBall() {
        Random random = new Random();
        int num = random.nextInt(10);
        return new VerticalBall((w*num)/10,0,w/20);
    }
    public void render() {
        Gdx.gl20.glClearColor(0,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        for(VerticalBall ball:balls) {
            ballSrpite.setPosition(ball.getX()-w/20,ball.getY()-w/20);
            ballSrpite.draw(batch);
            ball.move();
        }
        for(StoppingLine line:lines) {
            lineSprite.setPosition(line.getX()-w/20,line.getY()-w/20);
            lineSprite.draw(batch);
        }
        for(StoppingLine line:lines) {
            for(VerticalBall ball:balls) {
                if(ball.collide(line)) {
                    lines.remove(line);
                    balls.remove(ball);
                }
            }
        }
        batch.end();
        if(time%30 ==0 ){
            balls.add(createVerticalBall());
        }



        time++;
    }
    public void dispose() {

    }
}
