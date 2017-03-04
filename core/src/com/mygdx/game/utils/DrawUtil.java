package com.mygdx.game.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.sun.javafx.image.PixelAccessor;

/**
 * Created by anweshmishra on 24/10/16.
 */
public class DrawUtil {
    public static void drawClock(Pixmap pixmap,int x,int y,int r) {
        pixmap.setColor(Color.WHITE);
        pixmap.fillCircle(x,y,r);
        pixmap.setColor(Color.BLACK);
        pixmap.drawLine(x,y,x+r,y);
    }
    public static void drawDumble(Pixmap pixmap,int x,int y,int w) {
        pixmap.setColor(Color.BLACK);
        pixmap.fill();
        pixmap.setColor(Color.GREEN);
        pixmap.drawLine(x,y,x-w,y);
        pixmap.drawLine(x,y,x+w,y);
        pixmap.fillCircle(x-4*w/5,y,w/5);
        pixmap.fillCircle(x+4*w/5,y,w/5);
    }
    public static void drawDiver(Pixmap pixmap,int x,int y,int w) {
        pixmap.setColor(Color.BLACK);
        pixmap.fill();
        pixmap.setColor(Color.GREEN);
        pixmap.drawLine(x,y,x-w,y);
    }
    public static void drawDrick(Pixmap pixmap,int w,int h) {
        pixmap.setColor(Color.GREEN);
        int x = w/2,y = h/2;
        int r = w/8;
        int w1 = w/2,h1 = h/2;
        int ls[] = {1,-1,-1,1},rs[] = {1,1,-1,-1};
        for(int i=0;i<4;i++) {
            pixmap.drawLine(x,y,x+w1*ls[i],y+h1*rs[i]);
        }
        pixmap.fillCircle(x,y,r);
    }
    public static void drawDrickV2(Pixmap pixmap,int w,int h) {
        pixmap.setColor(Color.GREEN);
        int x = w/2,y = h/2,r = w/8;
        w = w/2;
        h = h/2;
        int xw_yh[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<xw_yh.length;i++) {
            pixmap.drawLine(x,y,x+w*xw_yh[i][0],y+h*xw_yh[i][1]);
        }
        pixmap.fillCircle(x,y,r);
    }
    public static void drawNipper(Pixmap pixmap,int w,int h) {
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        pixmap.setColor(Color.ORANGE);
        pixmap.drawLine(w/2,h/5,w/2,(h*4)/5);
        pixmap.fillCircle(w/2,h/10,h/10);
        pixmap.fillRectangle(w/2-h/10,(4*h)/5,h/5,h/5);
    }
}
