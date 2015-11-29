package com.bitbucket.nachuriken.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.bitbucket.nachuriken.Nachuriken;
import com.bitbucket.nachuriken.sprite.ground.Ground;

import java.util.Random;

/**
 * Ain't Nobody Got Time for That
 */
public class Ghost {

    private Vector3 position;
    private Vector3 velocity;
    private Texture ghost;
    private Rectangle bounds;

    public Ghost(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        ghost = new Texture("ghost.png");
        bounds = new Rectangle(x, y, ghost.getWidth(), ghost.getHeight());
    }

    public void update(float dt) {
        float random = (float) Math.random();

        if (position.y >= 200 ) {
            velocity.y = -random;
        } else if (position.y <= Ground.HEIGHT) {
            velocity.y = random;
        }

        velocity.x = -random;

        position.add(velocity.x, velocity.y, 0);
        bounds.setPosition(position.x, position.y);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return ghost;
    }
}
