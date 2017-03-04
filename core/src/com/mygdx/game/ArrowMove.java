package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketImpl;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 01/09/16.
 */
public class ArrowMove extends ApplicationAdapter{
    private Texture texture;
    private Sprite sprite;
    private SpriteBatch batch;
    private int w,h;
    int time = 0;
    private List<SideMovement> sideMovements = new ArrayList<SideMovement>();
    private SideMovement currentSideMovement;
    public void render() {

        Gdx.gl.glClearColor(0.34f,0.23f,0.54f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        for(SideMovement movement:sideMovements) {
            sprite.draw(batch);
            sprite.setPosition(movement.getX(),movement.getY());
            sprite.setRotation(movement.getDeg());
            movement.move();
        }
        batch.end();
    }
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        currentSideMovement = new SideMovement(w/2,h/2,0,0);
        sideMovements.add(currentSideMovement);
        Pixmap pixmap = new Pixmap(w/10,w/10, Pixmap.Format.RGB888);
        pixmap.setColor(0.34f,0.23f,0.54f,1);
        pixmap.fillRectangle(0,0,w/10,w/10);
        pixmap.setColor(Color.BLACK);

        pixmap.fillRectangle(w/30,w/10-2*w/25,w/30,w/10);

        pixmap.fillTriangle(0,w/10-(2*w)/25,w/10,w/10-(2*w)/25,w/20,0);
        texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        batch = new SpriteBatch();
        pixmap.dispose();
        Gdx.input.setInputProcessor(new GestureDetector(new GestureDetector.GestureAdapter(){
            public boolean touchDown(float x,float y,int pointet,int btn) {

                return true;
            }
            public boolean fling(float velx,float vely,int btn) {
                currentSideMovement.setDirection(velx/(Math.abs(velx)));
                currentSideMovement = new SideMovement(w/2,h/2,0,0);
                sideMovements.add(currentSideMovement);
                return true;
            }
        }));
    }
    public void dispose() {
        texture.dispose();
        batch.dispose();
    }
}
