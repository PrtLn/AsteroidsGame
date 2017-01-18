package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Bullet {
    private Vector2 position;
    private float speed;
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setup(float x, float y) {
        position.x = x;
        position.y = y;
        active = true;
    }

    public Bullet() {
        position = new Vector2(0f, 0f);
        speed = 12.0f;
        active = false;
    }

    public void destroy() {
        active = false;
    }

    public void update() {
        position.x += speed;
        if (position.x > 1280) {
            destroy();
        }
    }
}
