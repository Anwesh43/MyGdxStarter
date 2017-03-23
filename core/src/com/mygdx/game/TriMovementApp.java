package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.DemoAQBall;

/**
 * Created by anweshmishra on 23/03/17.
 */
public class TriMovementApp extends ApplicationAdapter {
    private Texture texture;
    private Sprite sprite;
    private SpriteBatch spriteBatch;
    private AnimationQueue animationQueue = new AnimationQueue();
    private int w,h,x=0,y=0;
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        x = w/3;
        y = h/3;
        Pixmap pixmap = new Pixmap(w/10,w/10, Pixmap.Format.RGB888);
        DemoAQBall.draw(pixmap);
        texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        sprite.setPosition(w/3,h/3);
        spriteBatch = new SpriteBatch();
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
            public boolean touchDown(int x1,int y1,int pntr,int btn) {
                animationQueue.addAnimation(new ObjectAnimation() {
                    @Override
                    public boolean isDone() {
                        boolean condition =  x>=2*w/3;
                        if(condition) {
                            x = 2*w/3;
                        }
                        return condition;
                    }

                    @Override
                    public void animate() {
                        x+=w/10;
                    }
                    public int hashCode() {
                        return 0;
                    }
                });
                animationQueue.addAnimation(new ObjectAnimation() {
                    @Override
                    public boolean isDone() {
                        boolean condition =  x<=w/2 && y<=h/6;
                        if(condition) {
                            x = w/2;
                            y = h/6;
                        }
                        return condition;
                    }

                    @Override
                    public void animate() {
                        x-=w/30;
                        y-=h/30;
                    }
                    public int hashCode() {
                        return 1;
                    }
                });
                animationQueue.addAnimation(new ObjectAnimation() {
                    @Override
                    public boolean isDone() {
                        boolean condition =  x<=w/3 && y<=h/3;
                        if(condition) {
                            x = w/3;
                            y = h/3;
                        }
                        return condition;
                    }

                    @Override
                    public void animate() {
                        x-=w/30;
                        y+=h/30;
                    }
                    public int hashCode() {
                        return 2;
                    }
                });
                return true;
            }
        });
        pixmap.dispose();
    }
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0,0,0,1);
        spriteBatch.begin();
        sprite.draw(spriteBatch);
        sprite.setPosition(x,y);
        animationQueue.execute();
        spriteBatch.end();
    }
    public void dispose() {
        texture.dispose();
        spriteBatch.dispose();
    }
}
