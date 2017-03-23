package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
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
    private int w,h;
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        Pixmap pixmap = new Pixmap(w/3,h/3, Pixmap.Format.RGB888);
        DemoAQBall.draw(pixmap);
        texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        sprite.setPosition(w/3,h/3);
        spriteBatch = new SpriteBatch();
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
            public boolean touchDown(int x,int y,int pntr,int btn) {
                animationQueue.addAnimation(new ObjectAnimation() {
                    @Override
                    public boolean isDone() {
                        boolean condition =  sprite.getX()>=(2*w/3);
                        if(condition) {
                            sprite.setX(2*w/3);
                        }
                        return condition;
                    }

                    @Override
                    public void animate() {
                        sprite.setPosition(sprite.getX()+w/10,sprite.getY());
                    }
                    public int hashCode() {
                        return 0;
                    }
                });
                animationQueue.addAnimation(new ObjectAnimation() {
                    @Override
                    public boolean isDone() {
                        boolean condition =  sprite.getX()<=w/2 && sprite.getY()<=h/6;
                        if(condition) {
                            sprite.setPosition(w/2,h/6);
                        }
                        return condition;
                    }

                    @Override
                    public void animate() {
                        sprite.setPosition(sprite.getX()-w/30,sprite.getY()-h/30);
                    }
                    public int hashCode() {
                        return 1;
                    }
                });
                animationQueue.addAnimation(new ObjectAnimation() {
                    @Override
                    public boolean isDone() {
                        boolean condition =  sprite.getX()<=w/3;
                        if(condition) {
                            sprite.setPosition(w/3,h/3);
                        }
                        return condition;
                    }

                    @Override
                    public void animate() {
                        sprite.setPosition(sprite.getX()-w/30,sprite.getY()+h/30);
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
        spriteBatch.begin();
        sprite.draw(spriteBatch);
        animationQueue.execute();
        spriteBatch.end();
    }
    public void dispose() {
        texture.dispose();
        spriteBatch.dispose();
    }
}
