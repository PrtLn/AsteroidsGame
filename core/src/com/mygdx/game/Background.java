package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Background {
    class Star {
        private Vector2 position; // position.x and position.y
        private float speed;

        public Star() {
            position = new Vector2((float)Math.random() * 1280,
                                   (float)Math.random() * 720);
            speed = 5.0f;
        }

        public void update() {
            position.x -= speed;
            if (position.x < 0) {
                position.x = 1280;
                position.y = (float)Math.random() * 720;
            }
        }
    }

    private Texture texture;

    public Background() {
        texture = new Texture("backspace.png");
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, 0, 0);
    }
}
