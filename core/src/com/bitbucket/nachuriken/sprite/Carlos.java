package com.bitbucket.nachuriken.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.bitbucket.nachuriken.state.PlayState;

/**
 * Ain't Nobody Got Time for That
 */
public class Carlos {

    public static final int GRAVITY = -15;
    public static final int MOVEMENT = 100;

    private Vector3 position;
    private Vector3 velocity;
    private Texture carlos;
    private Rectangle bounds;

    public Carlos(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        carlos = new Texture("player.png");
        bounds = new Rectangle(x, y, carlos.getWidth(), carlos.getHeight());
    }

    public void update(float dt) {
        if (position.y > PlayState.GROUND_HEIGHT) {
            velocity.add(0, GRAVITY, 0);
        }

        velocity.scl(dt);
        position.add(0, velocity.y, 0);

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
        return carlos;
    }
}
