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
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;


/**
 * Created by anweshmishra on 20/09/16.
 */
public class Box2dDemo extends ApplicationAdapter {
    private int w,h;
    private Sprite sprite;
    private Texture texture;
    private SpriteBatch batch;
    private World world;
    private Body body;
    private int index=0;
    public void render() {
        Gdx.gl20.glClearColor(0.82f,0.55f,0.39f,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        world.step(Gdx.graphics.getDeltaTime(),6,2);
        sprite.setRotation(body.getAngle());
        sprite.setPosition(body.getPosition().x,body.getPosition().y);
        batch.begin();
        sprite.draw(batch);
        batch.end();
    }
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        texture = new Texture("badlogic.jpg");
        sprite = new Sprite(texture);
        sprite.setPosition(w/2,0);
        batch = new SpriteBatch();
        world = new World(new Vector2(0,0),true);
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(sprite.getX(),sprite.getY());
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(sprite.getWidth()/2,sprite.getHeight()/2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.density=1;
        fixtureDef.shape = shape;
        body = world.createBody(bodyDef);
        body.createFixture(fixtureDef);
        shape.dispose();
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
            public boolean touchDown(int x,int y,int btn,int pointer) {
                if(x>sprite.getX() && x<sprite.getX()+sprite.getWidth() && h-y>sprite.getY() && h-y<sprite.getHeight()+sprite.getY()) {
                    //body.applyTorque(10,true);
                    index++;
                   // body.applyLinearImpulse(new Vector2(0,-300),body.getPosition(),false);
                    //body.applyAngularImpulse(50,true);
                    if(index%2==1) {
                        body.setLinearVelocity(new Vector2(100, 100));
                        body.setAngularVelocity(4);
                    }
                    else {
                        body.setLinearVelocity(new Vector2(0,0));
                        body.setAngularVelocity(0);
                    }
                    //body.applyForce(new Vector2(300,-150),new Vector2(sprite.getX()+sprite.getWidth()/2,sprite.getY()+sprite.getHeight()/2),true);
                }
                return true;
            }
        });

    }
    public void dispose() {
        texture.dispose();
        batch.dispose();
        world.dispose();
    }
}
