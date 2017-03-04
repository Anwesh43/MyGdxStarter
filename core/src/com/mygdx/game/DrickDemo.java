package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.objects.Drick;
import com.mygdx.game.utils.DrawUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by anweshmishra on 02/11/16.
 */
public class DrickDemo extends ApplicationAdapter{
    private int w,h;
    private int i = 0;
    private SpriteBatch batch;
    private Sprite drickSprite,drickSpriteV2;
    private Texture drickTexture,drickV2Texture;
    private ConcurrentLinkedQueue<Drick> dricks = new ConcurrentLinkedQueue<Drick>();
    public void render() {
        Gdx.gl20.glClearColor(0,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        for(Drick drick:dricks) {
            Sprite sprite = drick.getSprite();
            sprite.draw(batch);
            drick.shouldMove();
            sprite.setPosition(drick.getX(),drick.getY());
            sprite.setRotation(drick.getDeg());
            if(drick.isOver()) {
                dricks.remove(drick);
            }
        }
        batch.end();
    }
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        batch = new SpriteBatch();
        Pixmap pixmap = new Pixmap(w/10,w/10, Pixmap.Format.RGB888);
        DrawUtil.drawDrick(pixmap,w/10,w/10);
        drickTexture = new Texture(pixmap);
        Pixmap pixmap1 = new Pixmap(w/10,w/10, Pixmap.Format.RGB888);
        DrawUtil.drawDrickV2(pixmap1,w/10,w/10);
        drickV2Texture = new Texture(pixmap1);
        drickSprite = new Sprite(drickTexture);
        drickSpriteV2 = new Sprite(drickV2Texture);
        pixmap.dispose();
        pixmap1.dispose();
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
            public boolean touchDown(int x,int y,int btn,int pointer) {
                if(i%2 == 0) {
                    dricks.add(new Drick(x-w/10,0.9f*h-y,drickSprite));
                }
                else {
                    dricks.add(new Drick(x-w/10,0.9f*h-y,drickSpriteV2));
                }
                i++;
                return  true;
            }
        });
    }
    public void dispose() {
        drickTexture.dispose();
        drickV2Texture.dispose();
        batch.dispose();
        dricks = null;
    }
}
