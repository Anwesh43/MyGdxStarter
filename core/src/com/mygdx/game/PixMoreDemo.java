package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by anweshmishra on 27/08/16.
 */
public class PixMoreDemo extends ApplicationAdapter implements InputProcessor{
    private float x = 0,y = 0,deg,l=1,k=1;
    private Sprite sprite;
    private SpriteBatch batch;
    private Texture texture;
    private Pixmap pixmap;
    private int w,h;
    private float speed = 10;
    public void render() {
        Gdx.gl.glClearColor(0,0,1,0.5f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        sprite.draw(batch);
        //sprite.rotate(deg);
        sprite.setRotation(deg);
        sprite.setPosition(x,y);
        batch.end();
        x+=l*speed;
        y+=k*(speed*h)/w;
        if(x>=w) {
            x = w;
            l=-1;
        }
        if(x<=0) {
            x=0;
            l=1;
        }
        if(y>=h) {
            y = h;
            k=-1;
        }
        if(y<=0) {
            y=0;
            k=1;
        }
        deg+=speed*Math.PI/3;
    }
    public void create() {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        x = w/2;
        y = 0;
        pixmap = new Pixmap(w/10,w/10, Pixmap.Format.RGB888);
        pixmap.setColor(1,1,0,1);
        pixmap.fillRectangle(0,0,w/10,w/10);
        texture = new Texture(pixmap);
        sprite = new Sprite(texture);
        batch = new SpriteBatch();
        deg = (float)Math.PI/3;
        Gdx.input.setInputProcessor(this);
    }
    public void resize(int w,int h) {

    }
    public void dispose() {

    }
    public boolean keyDown (int keycode) {
        return true;
    }

    /** Called when a key was released
     *
     * @param keycode one of the constants in {@link Input.Keys}
     * @return whether the input was processed */
    public boolean keyUp (int keycode){
        return false;
    }

    /** Called when a key was typed
     *
     * @param character The character
     * @return whether the input was processed */
    public boolean keyTyped (char character) {
        return false;
    }

    /** Called when the screen was touched or a mouse button was pressed. The button parameter will be {@link Input.Buttons#LEFT} on iOS.
     * @param screenX The x coordinate, origin is in the upper left corner
     * @param screenY The y coordinate, origin is in the upper left corner
     * @param pointer the pointer for the event.
     * @param button the button
     * @return whether the input was processed */
    public boolean touchDown (int screenX, int screenY, int pointer, int button) {
        speed = speed == 0?10:0;
        Gdx.app.log("x,y",screenX+","+screenY);
        return true;
    }

    /** Called when a finger was lifted or a mouse button was released. The button parameter will be {@link Input.Buttons#LEFT} on iOS.
     * @param pointer the pointer for the event.
     * @param button the button
     * @return whether the input was processed */
    public boolean touchUp (int screenX, int screenY, int pointer, int button) {
        return false;
    }

    /** Called when a finger or the mouse was dragged.
     * @param pointer the pointer for the event.
     * @return whether the input was processed */
    public boolean touchDragged (int screenX, int screenY, int pointer) {
        return false;
    }

    /** Called when the mouse was moved without any buttons being pressed. Will not be called on iOS.
     * @return whether the input was processed */
    public boolean mouseMoved (int screenX, int screenY) {
        return false;
    }

    /** Called when the mouse wheel was scrolled. Will not be called on iOS.
     * @param amount the scroll amount, -1 or 1 depending on the direction the wheel was scrolled.
     * @return whether the input was processed. */
    public boolean scrolled (int amount) {
        return false;
    }
}
