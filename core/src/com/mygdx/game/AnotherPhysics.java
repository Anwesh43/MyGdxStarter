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
 * Created by anweshmishra on 21/09/16.
 */
public class AnotherPhysics extends ApplicationAdapter {
    private int w,h;
    private final static float curr_acc=-1000;
    private Sprite sprite;
    private World world;
    private Texture texture;
    private com.badlogic.gdx.physics.box2d.Body body;
    private SpriteBatch batch;
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();

        Pixmap pixmap = new Pixmap(w/10,w/10, Pixmap.Format.RGB888);
        pixmap.setColor(Color.BLACK);
        pixmap.fill();
        pixmap.setColor(Color.LIME);
        pixmap.fillCircle(w/20,w/20,w/20);
        texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        batch = new SpriteBatch();
        initPhysics();
        pixmap.dispose();
        Gdx.input.setInputProcessor(new InputProcessorAdapter(){
            public boolean touchDown(int x,int y,int pntr,int btn) {
                //body.applyForce(new Vector2(0,(body.getMass()*curr_acc)),body.getWorldCenter(),true);
                body.setLinearVelocity(new Vector2(0,-350));
                return true;
            }
        });

    }
    private void initPhysics() {
        world = new World(new Vector2(100,300),true);
        world.setContinuousPhysics(true);
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(new Vector2(sprite.getX()+sprite.getWidth()/2,sprite.getY()+sprite.getHeight()/2));
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bodyDef);
        MassData massData = new MassData();
        massData.mass=10;
        body.setMassData(massData);
        CircleShape circleShape = new CircleShape();
        circleShape.setPosition(new Vector2(sprite.getX()+sprite.getWidth()/2,sprite.getY()+sprite.getHeight()/2));
        circleShape.setRadius(sprite.getWidth()/2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.density=1;
        fixtureDef.shape = circleShape;
        body.createFixture(fixtureDef);
        circleShape.dispose();
    }
    public void render() {
        Gdx.gl20.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        world.step(Gdx.graphics.getDeltaTime(),6,2);
        sprite.setPosition(body.getPosition().x,body.getPosition().y);
        batch.begin();
        sprite.draw(batch);
        batch.end();
        if(body.getPosition().x>w) {
            //body.getPosition().set(0,body.getPosition().y);
            body.setTransform(0,body.getPosition().y,0);
        }
        if(body.getPosition().y>h) {
            body.setTransform(body.getPosition().x,0,0);
        }
    }
    public void dispose() {
        texture.dispose();
        world.dispose();
        batch.dispose();
    }
    public void resize(int w,int h) {

    }
}
