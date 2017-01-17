package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Background {
    private Texture texture;

    public Background() {
        texture = new Texture("backspace.png");
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, 0, 0);
    }
}
