package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Pikalova Lena on 1/18/2017.
 */

public class Asteroid {
    private Vector2 position;
    private float speed;
    private static Texture texture;
    private Rectangle rect;

    public Rectangle getRect() {
        return rect;
    }

    public Asteroid() {
        position = new Vector2(1280 + (float)Math.random() * 1280,
                (float)Math.random() * 720);
        speed = 3.0f + (float)Math.random() * 7.0f;
        rect = new Rectangle(position.x, position.y, 60, 60);
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
        rect.x = position.x;
        rect.y = position.y;
    }
}
