package com.mygdx.game;

import com.badlogic.gdx.InputProcessor;

/**
 * Created by anweshmishra on 28/08/16.
 */
public class InputProcessorAdapter implements InputProcessor {
    public boolean keyDown(int ar1) {
        return false;
    }
    public boolean keyUp(int ar1) {
        return false;
    }
    public boolean keyTyped(char character) {
        return false;
    }
    public boolean touchDown(int x,int y,int pointer,int button) {
        return false;
    }
    public boolean touchUp(int x,int y,int pointer,int button) {
        return false;
    }
    public boolean touchDragged(int x,int y,int pointer) {
        return false;
    }
    public boolean mouseMoved(int x,int y) {
        return false;
    }
    public boolean scrolled(int ar1) {
        return false;
    }
}
