package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by anweshmishra on 15/03/17.
 */
public class PhysicsDemoApp extends ApplicationAdapter {
    private Sprite sprite;
    private SpriteBatch spriteBatch;
    private Texture texture;
    private World world;
    private com.badlogic.gdx.physics.box2d.Body body;
    private int w,h;
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        world = new World(new Vector2(0,-98f),true);
        Pixmap pixmap = new Pixmap(w/10,w/10, Pixmap.Format.RGB888);
        pixmap.fill();
        pixmap.setColor(Color.GREEN);
        pixmap.fillCircle(w/20,w/40,w/40);
        pixmap.fillRectangle(w/40,w/20,w/20,w/20);
        texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        sprite.setPosition(w/2-w/20,h/2-w/20);
        spriteBatch = new SpriteBatch();
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(sprite.getX()+sprite.getWidth()/2,sprite.getY()+sprite.getHeight()/2);
        body = world.createBody(bodyDef);
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(sprite.getWidth()/2,sprite.getHeight()/2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = polygonShape;
        fixtureDef.density = 1;
        Fixture fixture = body.createFixture(fixtureDef);
        pixmap.dispose();
    }
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0,0,0,1);
        world.step()
        spriteBatch.begin();
        sprite.draw(spriteBatch);
        sprite.setRotation(sprite.getRotation()+3);
        spriteBatch.end();
    }
    public void dispose() {
        texture.dispose();
        spriteBatch.dispose();
    }
}
