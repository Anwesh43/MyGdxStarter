package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.BallGraph;
import com.mygdx.game.objects.LinePath;
import com.mygdx.game.objects.Point;
import com.mygdx.game.objects.VertexBall;

import java.util.ArrayList;
import java.util.List;

import sun.security.provider.certpath.Vertex;

/**
 * Created by anweshmishra on 24/09/16.
 */
public class GraphDraw extends ApplicationAdapter {
    private int w,h;
    private Texture texture;
    private SpriteBatch batch;
    private Sprite sprite;
    private int rotFactor = 0;
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        List<Point> points = new ArrayList<Point>(){{
            add(new Point(w/20,w/20));
            add(new Point(w/6+w/20,h/2+w/20));
            add(new Point(w/3+w/20,w/20));
            add(new Point(w/2+w/20,h/2+w/20));
            add(new Point(2*(w/3)+w/20,w/20));
        }};
        BallGraph graph = new BallGraph();


        while(points.size()>=2) {
            Point point = points.get(0);
            LinePath linePath = new LinePath(point);
            linePath.setEndpoint(points.get(1));
            graph.addEdges(linePath);
            graph.addVertices(new VertexBall(point,w/20));
            points.remove(0);
        }
        graph.addVertices(new VertexBall(points.get(0),w/20));
        Pixmap pixmap = new Pixmap((2*w/3)+w/10,h/2+w/10, Pixmap.Format.RGB888);
        pixmap.setColor(Color.BLACK);
        pixmap.fill();
        pixmap.setColor(Color.GREEN);
        graph.draw(pixmap);
        texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        batch = new SpriteBatch();
        pixmap.dispose();
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
            public boolean touchDown(int x,int y,int pntr,int btn) {
                rotFactor = rotFactor == 2?0:2;
                return true;
            }
        });
    }
    public void render() {
        Gdx.gl20.glClearColor(0,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        sprite.draw(batch);
        sprite.setRotation(sprite.getRotation()+rotFactor);
        batch.end();
    }
    public void dispose() {
        texture.dispose();
        batch.dispose();
    }
}
