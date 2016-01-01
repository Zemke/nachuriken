package com.bitbucket.nachuriken.state;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.bitbucket.nachuriken.sprite.ground.Ground;

/**
 * Ain't Nobody Got Time for That
 */
public class Nacho {

    public static final int GRAVITY = -15;

    private Vector3 position;
    private Vector3 velocity;
    private Texture texture;
    private Rectangle bounds;
    private boolean flipped;

    public Nacho(int x, int y, boolean flipped) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 200, 0);
        texture = new Texture("nacho.png");
        bounds = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
        this.flipped = flipped;
    }

    public void update(float dt) {
        if (position.y > Ground.HEIGHT) {
            velocity.add(flipped ? -500 : 500, GRAVITY, 0);
        }

        velocity.scl(dt);
        position.add(velocity.x, velocity.y, 0);

        velocity.scl(1 / dt);
        bounds.setPosition(position.x, position.y);

        if (position.y <= Ground.HEIGHT) {
            position.y = Ground.HEIGHT;
            velocity.y = 0;
        }

        velocity.x = 0;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return texture;
    }
}
