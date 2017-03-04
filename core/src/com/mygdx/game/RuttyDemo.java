package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.MovingBrick;

/**
 * Created by anweshmishra on 26/11/16.
 */
public class RuttyDemo extends ApplicationAdapter{
    private SpriteBatch batch;
    private Texture texture;
    private Sprite sprite;
    private MovingBrick movingBrick;
    private int w,h;
    public void render() {
        Gdx.gl20.glClearColor(33,33,33 ,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        sprite.setX(movingBrick.getX());
        sprite.setY(movingBrick.getY());
        sprite.setRotation(movingBrick.getDeg());
        movingBrick.move(h);
        sprite.draw(batch);
        batch.end();
    }
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        batch = new SpriteBatch();
        movingBrick = new MovingBrick(w/2,h/2);
        Pixmap pixmap = new Pixmap(w/10,h/10, Pixmap.Format.RGB888);
        pixmap.setColor(0,150,136 ,1);
        pixmap.fillRectangle(0,0,w/10,h/10);
        texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        pixmap.dispose();
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
            public boolean touchDown(int x,int y,int btn,int pntr) {
                y = h-y;
                if(movingBrick.getRotSpeed() == 0) {
                    if (y > movingBrick.getY() && movingBrick.getDirY() != 10) {
                        movingBrick.setRotSpeed(10);
                    }
                    if (y < movingBrick.getY() && movingBrick.getDirY() != -10) {
                        movingBrick.setRotSpeed(-10);
                    }
                }
                return true;
            }
        });
    }
    public void dispose() {
        texture.dispose();
        batch.dispose();
        movingBrick = null;
    }

}
