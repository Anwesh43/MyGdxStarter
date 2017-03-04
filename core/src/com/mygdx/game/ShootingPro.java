package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.mygdx.game.objects.Ball;
import com.mygdx.game.objects.RectShooter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 02/09/16.
 */
public class ShootingPro extends ApplicationAdapter {
    private Texture ballTexture;
    private Texture rectTexture;
    private BitmapFont yText;
    private Sprite ballSprite,rectSprite;
    private SpriteBatch batch;
    private int currentDirection = -1;
    private RectShooter shooter;
    private float currentDy;

    private List<Ball> balls = new ArrayList<Ball>();
    private boolean delayShoot = false;
    private int w,h;
    public void create() {
        w = Gdx.graphics.getWidth();h = Gdx.graphics.getHeight();
        Pixmap ballPixmap = new Pixmap(w/40,w/40, Pixmap.Format.RGB888);
        Pixmap rectPixmap = new Pixmap(w/10,w/20,Pixmap.Format.RGB888);
        rectPixmap.setColor(0.25f,0.12f,0.43f,1.0f);
        rectPixmap.fillRectangle(0,0,w/10,w/20);
        ballPixmap.setColor(0.34f,0.16f,0.25f,1.0f);
        ballPixmap.fill();
        ballPixmap.fillRectangle(0,0,w/40,w/40);
        ballPixmap.setColor(0.14f,0.23f,0.16f,1.0f);
        ballPixmap.fillCircle(w/80,w/80,w/80);
        ballTexture = new Texture(ballPixmap);
        rectTexture = new Texture(rectPixmap);
        ballSprite = new Sprite(ballTexture);
        rectSprite = new Sprite(rectTexture);
        yText = new BitmapFont();
        yText.setColor(Color.WHITE);
        currentDy = (Gdx.input.getAccelerometerY())/Math.abs(Gdx.input.getAccelerometerY());
        shooter = new RectShooter(w/2-w/10,h/2-w/20,0);
        batch = new SpriteBatch();

        ballPixmap.dispose();
        rectPixmap.dispose();
        Gdx.input.setInputProcessor(new GestureDetector(new GestureDetector.GestureAdapter(){
            public boolean touchDown(float x,float y,int btn,int pointer) {
                return true;
            }
            public boolean fling(float velx,float vely,int btn) {
                if (shooter.isFinishedMoving()) {
                    int prevDirection = (int) (Math.abs(velx) / velx);
                    if (currentDirection != prevDirection) {
                        currentDirection = prevDirection;
                        shooter.changeDirection(currentDirection);
                        delayShoot = true;
                    } else {
                        float x = shooter.getX();
                        if(currentDirection == 1){
                            x = shooter.getX()+w/10;
                        }
                        balls.add(new Ball(x, shooter.getY()+w/40,currentDirection));
                    }

                }
                return true;
            }
        }));
    }
    public void render() {
        Gdx.gl.glClearColor(0.34f,0.16f,0.25f,1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        float prevDy = Gdx.input.getAccelerometerY()/Math.abs(Gdx.input.getAccelerometerY());
        if(prevDy!=currentDy) {
            currentDy = prevDy;
            shooter.moveY(10*currentDy);
        }
//        float distanceY = Gdx.input.getAccelerometerY()<0?-1:1;
//        shooter.moveY(distanceY);
        //yText.draw(batch,"y accelerometer is "+Gdx.input.getAccelerometerY(),w/10,h/10);
        rectSprite.draw(batch);
        rectSprite.setPosition(shooter.getX(),shooter.getY());
        rectSprite.setRotation(shooter.getDeg());
        shooter.move();
        if(delayShoot) {
            if(shooter.isFinishedMoving()) {
                balls.add(new Ball(shooter.getX()+currentDirection*w/10,shooter.getY(),currentDirection));
                delayShoot = false;
            }
        }
        for(Ball ball:balls) {
            ballSprite.draw(batch);
            ballSprite.setPosition(ball.getX(),ball.getY());
            ball.move();
        }
        batch.end();
    }
    public void dispose() {
        ballTexture.dispose();
        rectTexture.dispose();
        yText.dispose();
    }
}
