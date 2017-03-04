package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by anweshmishra on 29/08/16.
 */
public class BounceUp extends ApplicationAdapter{
    private Texture texture;
    private SpriteBatch batch;
    private final float gravity = 0.1f;
    private Sprite sprite;
    private int w,h;
    private float x=0,y=0,ux=10,uy=-10,t=0,a=0,iu =0;
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        y =9*h/10;
        uy = -((h*1.0f)/(w*1.0f))*10;
        Pixmap pixmap = new Pixmap(w/10,h/10, Pixmap.Format.RGB888);
        pixmap.setColor(Color.CYAN);
        pixmap.fillRectangle(0,0,w/10,h/10);
        Texture texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        batch = new SpriteBatch();
        pixmap.dispose();
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
           public boolean touchDown(int x,int y,int a1,int btn) {
               //a = (h/5+(2*t+1)*gravity)/(t*t);
               iu = t;
               uy=2*Math.abs(uy);
               return true;
           }
        });
    }
    public void render() {
        Gdx.gl.glClearColor(0.78f,0.39f,0.44f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        sprite.draw(batch);
        sprite.setPosition(x,y);
        x=ux*t;
        y +=uy;
        //y =9*h/10- 0.5f*(gravity-a)*t*t;
        if(iu!=0 && t-iu == 5) {
            iu=0;
            uy = -((h*1.0f)/(w*1.0f))*10;
        }
//        else if(iu!=0){
//            a = (h/5+(2*t+1)*gravity)/(t*t);
//        }
        batch.end();
        if(x>w) {
            x=0;
            t=0;
            y=0.9f*h;
        }
        t++;
    }
    public void dispose() {
        texture.dispose();
        batch.dispose();
    }
}
