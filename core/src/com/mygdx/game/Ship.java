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
    private float angle;

    public Ship() {
        position = new Vector2(100, 100);
        texture = new Texture("ship.png");
        speed = 10.0f;
        angle = 0.0f;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y,
                    75, 55, 155, 115, 1.0f, 1.0f,
                    angle, 0, 0, 155, 115, false, false);
//        batch.draw(texture, position.x, position.y);
    }

    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            angle += 1.0f;
            if (angle > 15f) angle = 15f;
            position.y += speed;
            if (position.y > 720) {
                position.y = -120;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            angle -= 1.0f;
            if (angle < 25f) angle = -25f;
            position.y -= speed;
            if (position.y < 0) {
                position.y = 840;
            }
        }
        if (angle > 0) angle -= 0.5f;
        if (angle < 0) angle += 0.5f;
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
    }
}
