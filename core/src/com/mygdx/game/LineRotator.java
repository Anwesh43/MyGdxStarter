package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.RotatingLine;

/**
 * Created by anweshmishra on 13/09/16.
 */
public class LineRotator extends ApplicationAdapter{
    private Texture texture;
    private Sprite sprite;
    private RotatingLine line;
    private int w,h;
    private boolean isDown = false;
    private SpriteBatch batch;
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        Pixmap pixmap = new Pixmap(w/5,w/5, Pixmap.Format.RGB888);
        pixmap.setColor(0.34f,0.56f,0.75f,1.0f);
        pixmap.fill();
        pixmap.setColor(Color.BLACK);
        //pixmap.fillRectangle(w/20,w/80,w/20,w/40);
        pixmap.drawLine(w/10,w/10,w/5,w/10);
        line = new RotatingLine(w/2-w/10,h/2-w/10);
        texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        batch = new SpriteBatch();
        pixmap.dispose();
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
            public boolean touchDown(int x,int y,int btn,int pointer) {
                if(!isDown) {
                    line.move(x,h-y);
                    isDown = true;
                }
                return true;
            }
            public boolean touchDragged(int x,int y,int btn) {
                if(isDown) {
                    line.move(x,h-y);
                }
                return true;
            }
            public boolean touchUp(int x,int y,int pointer,int btn) {
                if(isDown) {
                    isDown = false;
                }
                return true;
            }
        });
    }
    public void render() {
        Gdx.gl.glClearColor(0.34f,0.56f,0.75f,1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        sprite.draw(batch);
        sprite.setPosition(line.getX(),line.getY());
        sprite.setRotation(line.getDeg());
        batch.end();
    }
    public void dispose() {
        texture.dispose();
        batch.dispose();
    }
    public void resize(int w,int h) {

    }
}
