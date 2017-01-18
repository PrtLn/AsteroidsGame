package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Ship {
    private Vector2 position;
    private Texture texture;
    private float speed;
    private int fireRate;
    private int fireCounter;

    public Ship() {
        position = new Vector2(100, 100);
        texture = new Texture("ship.png");
        speed = 5.0f;
        fireRate = 5;
        fireCounter = 0;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            position.y += speed;
            if (position.y > 720) {
                position.y = -120;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            position.y -= speed;
            if (position.y < 0) {
                position.y = 840;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            position.x -= speed;
            if (position.x < 0) {
                position.x = 0;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            position.x += speed;
            if (position.x > 1120) {
                position.x = 1120;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            fireCounter++;
            if (fireCounter > fireRate) {
                fireCounter = 0;
                fire();
            }
        }
    }

    public void fire() {
        for (int i = 0; i < MyGdxGame.bullets.length; i++) {
            if (!MyGdxGame.bullets[i].isActive()) {
                MyGdxGame.bullets[i].setup(position.x, position.y);
                break;
            }
        }
    }
}
