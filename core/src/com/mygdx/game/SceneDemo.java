package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.RotateByAction;

/**
 * Created by anweshmishra on 13/09/16.
 */
public class SceneDemo extends ApplicationAdapter {
    int w,h;
    private Stage stage;
    private Actor myActor;
    private class MyActor extends Actor {
        private Texture texture;
        public MyActor() {
            Pixmap pixmap = new Pixmap(w/10,w/10, Pixmap.Format.RGB888);
            pixmap.setColor(Color.BLACK);
            pixmap.fill();
            pixmap.setColor(0.34f,0.56f,0.65f,1.0f);
            pixmap.fillRectangle(0,0,w/20,w/10);
            pixmap.fillTriangle(w/20,0,w/20,w/10,w/10,w/20);
            texture = new Texture(pixmap);
        }
        public void draw(SpriteBatch batch,float alpha) {
            batch.draw(texture,w/2,h/2);
        }
    }
    public void render() {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        stage = new Stage();
        myActor = new MyActor();
        stage.addActor(myActor);
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
            public boolean touchDown(int x,int y,int ptr,int btn) {
                RotateByAction action = new RotateByAction();
                action.setAmount(90);
                action.setDuration(1000);
                myActor.addAction(action);
                return true;
            }
        });

    }
    public void dispose() {

    }
    public void resize(int w,int h) {

    }
}
