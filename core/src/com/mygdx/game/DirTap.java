package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.mygdx.game.objects.Cross;
import com.mygdx.game.objects.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 05/09/16.
 */
public class DirTap extends ApplicationAdapter{
    private Texture texture;
    private SpriteBatch batch;
    private Sprite sprite;
    private OrthographicCamera camera;
    private int w,h;
    private Cross cross;
    private List<Cross> crosses = new ArrayList<Cross>();
    public void render() {
        Gdx.gl.glClearColor(0.23f,0.65f,0.46f,1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //batch.setProjectionMatrix(camera.combined);
        batch.begin();
        sprite.setPosition(cross.getStart().x,cross.getStart().y);
        sprite.setRotation(0);
        sprite.draw(batch);

        for(Cross currentCross:crosses) {
            sprite.draw(batch);
            sprite.setPosition(currentCross.getStart().x,currentCross.getStart().y);
            sprite.setRotation(currentCross.getDeg());
            currentCross.move();
        }
        batch.end();
    }
    public void dispose() {
        texture.dispose();
        batch.dispose();
    }
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        camera = new OrthographicCamera(w,h);
        Pixmap pixmap = new Pixmap(w/10,w/10, Pixmap.Format.RGB888);
        pixmap.setColor(0.23f,0.65f,0.46f,1.0f);
        pixmap.fill();
        pixmap.setColor(Color.CYAN);
        pixmap.drawLine(0,0,w/10,w/10);
        pixmap.drawLine(0,w/10,w/10,0);
        pixmap.fillCircle(w/20,w/20,w/60);
        texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        batch = new SpriteBatch();
        cross = new Cross(new Point(w/2,h/2-w/10));
        pixmap.dispose();
        Gdx.input.setInputProcessor(new GestureDetector(new GestureDetector.GestureAdapter(){
            public boolean tap(float x,float y,int ptr,int btn) {
                return true;
            }
            public boolean fling(float velx,float vely,int brn) {
                float dir = (Math.abs(velx))/velx;
                cross.setDirection(dir);
                crosses.add(cross);
                cross = new Cross(new Point(w/2,h/2-w/10));
                return true;
            }
            public boolean pan(float x,float y,float deltax,float deltay) {
                camera.translate(deltax,0);
                camera.update();
                return true;
            }
        }));
    }
}
