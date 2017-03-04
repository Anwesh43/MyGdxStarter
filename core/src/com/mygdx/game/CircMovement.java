package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.CollidingBall;
import com.mygdx.game.objects.Point;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 06/09/16.
 */
public class CircMovement extends ApplicationAdapter {
    private Sprite sprite;

    private Texture texture;
    private SpriteBatch batch;
    private int w,h;
    private List<CollidingBall> balls = new ArrayList<CollidingBall>();
    public void render() {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        for(int i=0;i<balls.size();i++) {
            CollidingBall ball = balls.get(i);
            sprite.setPosition(ball.getX(),ball.getY());
            sprite.draw(batch);
            ball.move();
        }
        batch.end();
    }
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        Pixmap pixmap = new Pixmap(w/10,w/10, Pixmap.Format.RGB888);
        pixmap.setColor(Color.BLACK);
        pixmap.fill();
        pixmap.setColor(Color.GREEN);
        pixmap.fillCircle(w/20,w/20,w/20);
        texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        balls.add(new CollidingBall(w-w/10,h/2-w/20,h));
        batch = new SpriteBatch();
        pixmap.dispose();
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
           public boolean touchDown(int x,int y,int btn,int pointer) {
               if(balls.size()!=0) {
                   CollidingBall ball = balls.get(balls.size()-1);
                   ball.setSpeedY(x,h-y);
                   balls.add(new CollidingBall(w-w/10,h/2-w/20,h));
               }
               return true;
           }
        });
    }
    public void resize(int w,int h) {

    }
    public void dispose() {
        texture.dispose();
        batch.dispose();
    }
}
