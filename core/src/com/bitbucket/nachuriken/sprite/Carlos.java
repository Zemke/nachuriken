package com.bitbucket.nachuriken.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Ain't Nobody Got Time for That
 */
public class Carlos {

    public static final int GRAVITY = -15;
    public static final int MOVEMENT = 100;

    private Vector3 position;
    private Vector3 velocity;
    private Texture Carlos;
    private Rectangle bounds;

    public Carlos(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        Carlos = new Texture("player.png");
        bounds = new Rectangle(x, y, Carlos.getWidth(), Carlos.getHeight());
    }

    public void update(float dt) {
        if (position.y > 0) {
            velocity.add(0, GRAVITY, 0);
        }

        velocity.scl(dt);
        position.add(MOVEMENT * dt, velocity.y, 0);

        if (position.y < 0) {
            position.y = 0;
        }

        velocity.scl(1 / dt);
        bounds.setPosition(position.x, position.y);
    }

    public void jump() {
        velocity.y = 250;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return Carlos;
    }
}
