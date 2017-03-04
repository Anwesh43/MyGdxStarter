package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.TriangleBall;

/**
 * Created by anweshmishra on 16/10/16.
 */
public class TriangleRun extends ApplicationAdapter {
    private SpriteBatch batch;//to draw the srpite
    private Sprite sprite;
    private Texture texture;//hold sprite's image or graphics data
    private TriangleBall ball;//object which will containe x and y coordinates
    private int w,h;
    public void create() {
        //defining /intializing the objects
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        ball = new TriangleBall(w/2,0,h,w/10);
        batch = new SpriteBatch();
        //let's create the sprite
        Pixmap pixmap = new Pixmap(w/10,w/10, Pixmap.Format.RGB888);
        pixmap.setColor(Color.GREEN);
        pixmap.fillCircle(w/20,w/20,w/20);
        //pixmap will hold data for the the texture
        //lets create texture
        texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        pixmap.dispose();
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
           public boolean touchDown(int x,int y,int btn,int pntr) {
               ball.changeMode();
               return true;
           }
        });
    }
    public void render() {
        //We are rendering the sprite here
        Gdx.gl20.glClearColor(0,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        sprite.draw(batch);
        sprite.setPosition(ball.getX(),ball.getY());
        ball.move();
        batch.end();
    }
    public void dispose() {
        //we need to do this else there will be memory leak
        ball = null;
        texture.dispose();
        batch.dispose();
    }
}
