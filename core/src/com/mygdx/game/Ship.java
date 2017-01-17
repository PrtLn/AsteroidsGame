package com.mygdx.game;

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
        speed = 12.0f;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void update() {

    }
}
