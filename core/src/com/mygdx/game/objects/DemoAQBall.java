package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;

/**
 * Created by anweshmishra on 23/03/17.
 */
public class DemoAQBall {
    public static void draw(Pixmap pixmap) {
        pixmap.setColor(Color.GREEN);
        pixmap.fillCircle(pixmap.getWidth()/2,pixmap.getHeight()/2,pixmap.getWidth()/2);
    }
}
