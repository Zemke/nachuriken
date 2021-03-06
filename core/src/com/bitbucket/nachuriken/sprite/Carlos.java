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
    public static final int JUMP_VELOCITY = 350;
    public static final int DIRECTION_MOVEMENT = 200;
    private boolean flipped;

    private Animation animation;

    private Vector3 position;
    private Vector3 velocity;
    private Texture carlos;
    private Texture crouchedCarlos;
    private Texture jumpingCarlos;
    private boolean crouched;
    private Rectangle bounds;
    private boolean moving;
    private boolean dieing;

    public Carlos(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        carlos = new Texture("player-run.png");
        crouchedCarlos = new Texture("player-crouch.png");
        jumpingCarlos = new Texture("player-jump.png");
        animation = new Animation(new TextureRegion(carlos), 3, 0.3f);
        bounds = new Rectangle(x + (jumpingCarlos.getWidth() / 4), y, jumpingCarlos.getWidth() / 2, jumpingCarlos.getHeight());
        flipped = false;
        dieing = false;
    }

    public void update(float dt) {
        if (dieing) {
            if (position.y < -200) {
                position.x = 504;
                dieing = false;
            }

            velocity.add(velocity.x, -300, 0);

            velocity.scl(dt);
            position.add(velocity.x, velocity.y, 0);
            return;
        }

        animation.update(dt, moving);

        if (position.y > Ground.HEIGHT) {
            velocity.add(0, GRAVITY, 0);
        }

        velocity.scl(dt);
        position.add(velocity.x, velocity.y, 0);

        velocity.scl(1 / dt);
        bounds.setPosition(position.x + (jumpingCarlos.getWidth() / 4), position.y);

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
        return animation.getFrame();
    }

    public boolean isFlipped() {
        return flipped;
    }

    public void setFlipped(boolean flipped) {
        this.flipped = flipped;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public boolean isCrouched() {
        return crouched;
    }

    public void setCrouched(boolean crouched) {
        this.crouched = crouched;
    }

    public Texture getCrouchedCarlos() {
        return crouchedCarlos;
    }

    public void setCrouchedCarlos(Texture crouchedCarlos) {
        this.crouchedCarlos = crouchedCarlos;
    }

    public Texture getJumpingCarlos() {
        return jumpingCarlos;
    }

    public void setJumpingCarlos(Texture jumpingCarlos) {
        this.jumpingCarlos = jumpingCarlos;
    }

    public void dieHard() {
        dieing = true;
    }

    public boolean isDieing() {
        return dieing;
    }
}
