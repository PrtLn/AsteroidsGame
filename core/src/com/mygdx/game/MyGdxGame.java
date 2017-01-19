package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Pikalova Lena on 1/17/2017.
 */

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Background background;
	private Ship ship;
	private Asteroid[] asteroids;
	private final int ASTEROIDS_COUNT = 30;
	public static Bullet[] bullets;
	private final int BULLETS_COUNT = 100;
	private Texture textureBullet;

	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Background();
		ship = new Ship();
		asteroids = new Asteroid[ASTEROIDS_COUNT];
		for (int i = 0; i < asteroids.length; i++) {
			asteroids[i] = new Asteroid();
		}
		bullets = new Bullet[BULLETS_COUNT];
		for (int i = 0; i < bullets.length; i++) {
			bullets[i] = new Bullet();
		}
		textureBullet = new Texture("bullet.png");
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 0, 0, 1); // RGBA
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		background.render(batch);
		ship.render(batch);
		for (int i = 0; i < bullets.length; i++) {
			if (bullets[i].isActive())
				batch.draw(textureBullet,
						bullets[i].getPosition().x + 140f,
						bullets[i].getPosition().y + 40f);
		}
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
		for (int i = 0; i < bullets.length; i++) {
			if (bullets[i].isActive())
				bullets[i].update();
			for (int j = 0; j < asteroids.length; j++) {
				if (asteroids[j].getRect().contains(bullets[i].getPosition())) {
					asteroids[j].recreate();
					bullets[i].destroy();
					break;
				}
			}
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
