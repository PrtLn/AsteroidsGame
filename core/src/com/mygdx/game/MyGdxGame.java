package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Background background;
	Ship ship;
	Asteroid[] asteroids;
	final int ASTEROIDS_COUNT = 30;

	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Background();
		ship = new Ship();
		asteroids = new Asteroid[ASTEROIDS_COUNT];
		for (int i = 0; i < asteroids.length; i++) {
			asteroids[i] = new Asteroid();
		}
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 0, 0, 1); // RGBA
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		background.render(batch);
		ship.render(batch);
		for (int i = 0; i < asteroids.length; i++) {
			asteroids[i].render(batch);
		}
		batch.end();
	}

	public void update() {
		background.update();
		ship.update();
		for (int i = 0; i < asteroids.length; i++) {
			asteroids[i].update();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
