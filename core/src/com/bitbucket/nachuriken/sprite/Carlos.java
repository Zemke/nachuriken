package com.bitbucket.nachuriken.sprite;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.bitbucket.nachuriken.sprite.ground.Ground;

/**
 * Ain't Nobody Got Time for That
 */
public class Carlos {

    public static final int GRAVITY = -15;
    public static final int JUMP_VELOCITY = 250;
    public static final int DIRECTION_MOVEMENT = 70;

    private Animation carlosAnimation;

    private Vector3 position;
    private Vector3 velocity;
    private Texture carlos;
    private Rectangle bounds;

    public Carlos(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        carlos = new Texture("player-run.png");
        carlosAnimation = new Animation(new TextureRegion(carlos), 3, 0.5f);
        bounds = new Rectangle(x, y, carlos.getWidth(), carlos.getHeight());
    }

    public void update(float dt) {
        carlosAnimation.update(dt);

        if (position.y > Ground.HEIGHT) {
            velocity.add(0, GRAVITY, 0);
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

    public void jump() {
        if (isInTheAir()) {
            return;
        }
        velocity.y = JUMP_VELOCITY;
    }

    public void move(int direction) {
        if (direction == Input.Keys.LEFT) {
            velocity.x = DIRECTION_MOVEMENT * (-1);
        } else {
            velocity.x = DIRECTION_MOVEMENT;
        }
    }

    public boolean isInTheAir() {
        return velocity.y != 0.0;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getTexture() {
        return carlosAnimation.getFrame();
    }
}
