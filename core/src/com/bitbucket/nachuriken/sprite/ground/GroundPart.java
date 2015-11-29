package com.bitbucket.nachuriken.sprite.ground;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Ain't Nobody Got Time for That
 */
public class GroundPart {

    private Vector3 position;
    private Texture texture;
    private Rectangle bounds;

    public GroundPart(int x) {
        position = new Vector3(x, 0, 0);
        texture = new Texture("ground.png");
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return texture;
    }
}
