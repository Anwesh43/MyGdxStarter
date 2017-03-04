package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.FollowingBall;

/**
 * Created by anweshmishra on 12/09/16.
 */
public class TouchMover extends ApplicationAdapter{
    private SpriteBatch batch;
    private float crossX,crossY;
    private Sprite sprite,crossSprite;
    private Texture texture,crossTexture;
    private int w,h;
    private FollowingBall ball;
    public void render() {
        Gdx.gl.glClearColor(0.34f,0.43f,0.23f,1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        sprite.draw(batch);
        sprite.setPosition(ball.getX(),ball.getY());
        sprite.setRotation(ball.getDeg());
        ball.move();
        boolean isBallColliding = ball.getX()+w/10>=crossX && ball.getX()<=crossX+w/10 && ball.getY()+w/10>=crossY && ball.getY()<=crossY+w/10;
        if(!isBallColliding && ball.isMoving()) {
            crossSprite.draw(batch);
            crossSprite.setPosition(crossX,crossY);
        }

        batch.end();
    }
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        batch = new SpriteBatch();
        ball =new FollowingBall(w/2-w/20,h/2-w/20);
        Pixmap pixmap = new Pixmap(w/10,w/10, Pixmap.Format.RGB888);
        pixmap.setColor(0.34f,0.43f,0.23f,1.0f);
        pixmap.fill();
        pixmap.setColor(0.12f,0.24f,0.53f,1.0f);
        pixmap.fillCircle(w/40,w/20,w/40);
        pixmap.fillTriangle(w/20,0,w/20,w/10,w/10,w/20);
        texture = new Texture(pixmap);
        Pixmap crossPixmap = new Pixmap(w/10,w/10, Pixmap.Format.RGB888);
        crossPixmap.setColor(0.34f,0.43f,0.23f,1.0f);
        crossPixmap.fill();
        crossPixmap.setColor(0.25f,0.25f,0.45f,1.0f);
        crossPixmap.fillCircle(w/20,w/20,w/10);
        crossPixmap.setColor(0.53f,0.91f,0.94f,1.0f);
        crossPixmap.drawLine(0,0,w/10,w/10);
        crossPixmap.drawLine(w/10,0,0,w/10);

        crossTexture = new Texture(crossPixmap);
        sprite = new Sprite(texture);
        crossSprite = new Sprite(crossTexture);
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
            public boolean touchDown(int x,int y,int btn,int pointer) {
                ball.setFollowVariables(x,h-y);
                crossX = x;
                crossY = h-y;
                return true;
            }
        });
        pixmap.dispose();
    }
    public void resize(int w,int h) {

    }
    public void dispose() {
        texture.dispose();
        crossTexture.dispose();
        batch.dispose();
    }
}
