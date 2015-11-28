package com.bitbucket.nachuriken.sprite.ground;

import com.badlogic.gdx.graphics.Texture;

/**
 * Ain't Nobody Got Time for That
 */
public class GroundPart {

    private final int x;
    private final int y;
    private final Texture texture;

    public GroundPart(int x) {
        this.x = x;
        this.y = 0;
        texture = new Texture("ground.png");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Texture getTexture() {
        return texture;
    }
}
