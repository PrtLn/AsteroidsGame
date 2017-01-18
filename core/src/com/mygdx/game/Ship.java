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

    public Ship() {
        position = new Vector2(100, 100);
        texture = new Texture("ship.png");
        speed = 10.0f;
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


    }
}
