package com.bitbucket.nachuriken.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

/**
 * Ain't Nobody Got Time for That
 */
public class Ghost {

    public static final int MAX_SPEED = 200;
    public static final int MIN_SPEED = 10;
    public static final int MAX_HEIGHT = 30;
    public static final int MIN_HEIGHT = 0;
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
        Random random=new Random();
        int randomNumber=(random.nextInt(MAX_HEIGHT)-MIN_HEIGHT);

        velocity.add(
                -(MIN_SPEED + (int)(Math.random() * ((MAX_SPEED - MIN_SPEED) + 1))),
                randomNumber,
                0);

        velocity.scl(dt);
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
