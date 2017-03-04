package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.CirclePath;
import com.mygdx.game.objects.RotatingBall;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 28/09/16.
 */
public class BallMover extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture ballTexture,circleTexture;
    private Sprite circleSprite,ballSprite;
    private CirclePath currentCirclePath;
    private RotatingBall ball;
    private List<CirclePath> paths = new ArrayList<CirclePath>();
    private int w,h;
    public void render() {
        Gdx.gl20.glClearColor(0,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        ballSprite.draw(batch);
        ballSprite.setPosition(ball.getX(),ball.getY());
        circleSprite.draw(batch);
        circleSprite.setPosition(currentCirclePath.getX(),currentCirclePath.getY());
        ball.move();
        batch.end();
    }
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        batch = new SpriteBatch();
        ball = new RotatingBall(w/2+w/10,h/2+w/10,w/10);
        currentCirclePath = new CirclePath(w/2,h/2);
        currentCirclePath.setVisited(true);
        paths.add(currentCirclePath);
        Pixmap ballPixmap = new Pixmap(w/40,w/40, Pixmap.Format.RGBA8888);
        ballPixmap.setColor(Color.BLACK);
        ballPixmap.fill();
        ballPixmap.setColor(Color.GREEN);
        ballPixmap.fillCircle(w/80,w/80,w/40);
        Pixmap circlePixamp = new Pixmap(w/5,w/5, Pixmap.Format.RGBA8888);
        circlePixamp.setColor(Color.BLACK);
        circlePixamp.fill();
        circlePixamp.setColor(Color.GREEN);
        circlePixamp.drawCircle(w/10,w/10,w/10);
        ballTexture = new Texture(ballPixmap);
        circleTexture = new Texture(circlePixamp);
        ballSprite = new Sprite(ballTexture);
        circleSprite = new Sprite(circleTexture);
        ballPixmap.dispose();
        circlePixamp.dispose();

    }

    public void dispose() {
        ballTexture.dispose();
        circleTexture.dispose();
        batch.dispose();
    }
}
