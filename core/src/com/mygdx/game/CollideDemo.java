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
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by anweshmishra on 23/09/16.
 */
public class CollideDemo extends ApplicationAdapter {
    private World world;
    private Sprite ball1Sprite;
    private Texture ball1Texture;
    private Body ball1Body,ball2Body;
    private int w,h;
    private SpriteBatch batch;
    public void render() {
        Gdx.gl20.glClearColor(0,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        world.step(Gdx.graphics.getDeltaTime(),6,2);
        batch.begin();
        ball1Sprite.setPosition(ball1Body.getPosition().x,ball1Body.getPosition().y);
        ball1Sprite.draw(batch);
        ball1Sprite.setPosition(ball2Body.getPosition().x,ball2Body.getPosition().y);
        ball1Sprite.draw(batch);
        batch.end();
    }
    public void create() {
        batch = new SpriteBatch();
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        Pixmap pixmap = new Pixmap(w/10,w/10, Pixmap.Format.RGB888);
        pixmap.setColor(Color.BLACK);
        pixmap.fill();
        pixmap.setColor(Color.GREEN);
        pixmap.fillCircle(w/20,w/20,w/20);
        ball1Texture = new Texture(pixmap);
        ball1Sprite = new Sprite(ball1Texture);
        MassData massData = new MassData();
        massData.mass = 10;
        massData.center.set(w/20,w/20);
        world = new World(new Vector2(0,0),true);
        EdgeShape edgeShape = new EdgeShape();
        CircleShape ball1Shape = new CircleShape();
        ball1Shape.setPosition(new Vector2(w/2,h/2));
        ball1Shape.setRadius(w/20);
        edgeShape.set(-w/20,-w/20,w/20,w/20);
        FixtureDef ball1Fixture = new FixtureDef();
        ball1Fixture.restitution = 0.5f;
        ball1Fixture.density=1;
        ball1Fixture.shape = edgeShape;
        final BodyDef ball1Def = new BodyDef();
        ball1Def.type = BodyDef.BodyType.KinematicBody;
        ball1Def.position.set(w/2-w/20,h/2-w/20);
        ball1Body = world.createBody(ball1Def);
        ball1Body.createFixture(ball1Fixture);
        ball1Body.setMassData(massData);
        final BodyDef ball2Def = new BodyDef();
        ball2Def.type = BodyDef.BodyType.KinematicBody;
        ball2Def.position.set(w-w/10,h-w/10);
        ball2Body = world.createBody(ball2Def);
        ball2Body.setMassData(massData);
        CircleShape ball2Shape = new CircleShape();
        ball2Shape.setPosition(new Vector2(w-w/20,h-w/20));
        ball2Shape.setRadius(w/20);
        FixtureDef ball2Fixture = new FixtureDef();
        ball2Fixture.density=1;
        ball2Fixture.restitution=0.5f;
        ball2Fixture.shape = ball2Shape;
        ball2Body.createFixture(ball2Fixture);
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
           public boolean touchDown(int x,int y,int btn,int pntr) {
               y = h-y;
               if(x>=ball1Body.getPosition().x && x<=ball1Body.getPosition().x+w/10 && y>=ball1Body.getPosition().y && y<=ball1Body.getPosition().y+w/10) {
                   ball2Body.getPosition().set(w-w/10,h-w/10);
                   ball2Body.setLinearVelocity(new Vector2(0,0));
               }
               else {
                   float xvel = -320;
                   float yvel = xvel * (float) (Math.abs(y * 1.0 - ball2Def.position.y * 1.0)/Math.abs((x * 1.0 - ball2Def.position.x * 1.0)));
                   ball2Body.setLinearVelocity(new Vector2(xvel, yvel));
               }
               return true;
           }
        });
        world.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {
                contact.getFixtureA().getBody();
            }

            @Override
            public void endContact(Contact contact) {

            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {

            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {
                impulse.getNormalImpulses();
            }
        });
    }
    public void dispose() {
        ball1Texture.dispose();
        world.dispose();
        batch.dispose();
    }
}
