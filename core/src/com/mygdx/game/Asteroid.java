package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {
    private Vector2 position;
    private float speed;
    private static Texture texture;

    public Asteroid() {
        position = new Vector2(1280 + (float)Math.random() * 1280,
                (float)Math.random() * 720);
        speed = 35.0f + (float)Math.random() * 7.0f;
        if (texture == null)
            texture = new Texture("asteroid.png");
    }

    public void recreate() {
        position.x = 1280 + (float)Math.random() * 1280;
        position.y = (float)Math.random() * 720;
        speed = 3.0f + (float)Math.random() * 7.0f;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void update() {
        position.x -= speed;
        if (position.x < -85) {
            recreate();
        }
    }

}
