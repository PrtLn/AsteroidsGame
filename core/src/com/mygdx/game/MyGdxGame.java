package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Background background;

	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Background();
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 0, 0, 1); // RGBA
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		background.render(batch);
		batch.end();
	}

	public void update() {
		
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
