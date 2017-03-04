package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 03/09/16.
 */
public class Physics1Demo extends ApplicationAdapter{
    private SpriteBatch batch;
    private Sprite sprite;
    private Texture texture;
    private int w,h;
    boolean isDown = false;
    private List<List<Point>> pointsHistory = new ArrayList<List<Point>>();
    private List<Point> points = new ArrayList<Point>();
    boolean isMoveHistory = false;
    public void render() {
        Gdx.gl20.glClearColor(0.25f,0.16f,0.23f,1.0f);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        sprite.draw(batch);
        if(!isDown && points.size()>0) {
            Point point = points.get(0);
            sprite.setPosition(point.x,h-point.y);
            points.remove(0);
        }
        if(isMoveHistory && points.size() == 0 && pointsHistory.size()>0) {
            points = pointsHistory.get(0);
            pointsHistory.remove(0);
            if(pointsHistory.size() == 0) {
                isMoveHistory = false;
            }
        }
        batch.end();
    }
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        Pixmap pixmap = new Pixmap(w/10,w/10, Pixmap.Format.RGB888);
        pixmap.setColor(0.25f,0.16f,0.23f,1.0f);
        pixmap.fill();
        pixmap.setColor(0.35f,0.23f,0.54f,1.0f);
        pixmap.fillCircle(w/20,w/20,w/20);
        texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        batch = new SpriteBatch();
        pixmap.dispose();
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
            public boolean touchDown(int x,int y,int btn,int pointer) {

                if(!isDown && points.size()==0) {
                    float spx = sprite.getX(),spy = h-sprite.getY(),spw = sprite.getWidth(),sph= sprite.getHeight();
                    if(spx+spw>=x && spx<=x && spy-sph<=y && spy>=y) {
                        points.add(new Point(x, y));
                        isDown = true;
                    }
                    else if(!isMoveHistory && pointsHistory.size()>0){
                        isMoveHistory = true;
                    }
                }
                return true;
            }
            public boolean touchDragged(int x,int y,int btn) {
                if(isDown) {
                    points.add(new Point(x,y));
                }
                return true;
            }
            public boolean touchUp(int x,int y,int pointer,int btn) {
                if(isDown) {
                    List<Point> newPoints = new ArrayList<Point>();
                    for(Point point:points) {
                        newPoints.add(point);
                    }
                    pointsHistory.add(newPoints);
                    isDown = false;
                }
                return true;
            }
        });
    }
    public void dispose() {
        texture.dispose();
        batch.dispose();
        points = null;
        pointsHistory = null;
    }
}
