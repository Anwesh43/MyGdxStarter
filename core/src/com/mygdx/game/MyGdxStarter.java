package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class MyGdxStarter extends ApplicationAdapter {
	SpriteBatch batch;
	BitmapFont font;
	Texture img;
	private float x = 0, y= 200,k = -1;
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		font = new BitmapFont();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		font.draw(batch,"Hello World",x,300);
		batch.end();
		batch.begin();
		batch.draw(img,0,y);
		batch.end();
		x+=3;
		if(x >= 300) {
			x = 0;
		}
		y-=k*5;
		if(y>=400) {
			k=1;
		}
		if(y<=0) {
			k=-1;
		}

	}
}
