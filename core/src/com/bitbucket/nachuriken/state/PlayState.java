package com.bitbucket.nachuriken.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bitbucket.nachuriken.Nachuriken;
import com.bitbucket.nachuriken.sprite.Carlos;
import com.bitbucket.nachuriken.sprite.Ghost;
import com.bitbucket.nachuriken.sprite.ground.Ground;
import com.bitbucket.nachuriken.sprite.ground.GroundPart;

import java.util.ArrayDeque;

/**
 * Ain't Nobody Got Time for That
 */
public class PlayState extends AbstractState {

    private final Carlos carlos;
    private final Ghost ghost;
    private Ground ground;

    public PlayState(GameStateManager gsm) {
        super(gsm);

        cam.setToOrtho(false, Nachuriken.WIDTH / 2, Nachuriken.HEIGHT / 2);
        ground = new Ground();
        carlos = new Carlos(Ground.WIDTH + (Ground.WIDTH / 2), Ground.HEIGHT);
//        ghost = new Ghost(Nachuriken.WIDTH, Ground.HEIGHT);
        ghost = new Ghost(500, Ground.HEIGHT);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched() || Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            carlos.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        updateGround();
        cam.position.x = carlos.getPosition().x + 80;

        carlos.update(dt);
        ghost.update(dt);

        cam.update();
    }

    /**
     *
     *
     *                       .
     * __|________|_________|_________|__
     *   |        |         |         |
     *
     */
    private void updateGround() {
        ArrayDeque<GroundPart> groundParts = ground.getGroundParts();

        float startOfFirst = groundParts.getFirst().getPosition().x;
        float endOfFirst = startOfFirst + groundParts.getFirst().getTexture().getWidth();

        if (endOfFirst + Ground.WIDTH > carlos.getPosition().x) {
            GroundPart newFirst = groundParts.pollLast();
            newFirst.getPosition().x = startOfFirst - Ground.WIDTH;
            groundParts.addFirst(newFirst);
            System.out.println("Add to left");
        }

        float startOfLast = groundParts.getLast().getPosition().x;

        if (startOfLast - Ground.WIDTH < carlos.getPosition().x) {
            GroundPart newLast = groundParts.pollFirst();
            newLast.getPosition().x = startOfLast + Ground.WIDTH;
            groundParts.addLast(newLast);
            System.out.println("Add to right");
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();

        for (GroundPart groundPart : ground.getGroundParts()) {
            sb.draw(groundPart.getTexture(),
                    groundPart.getPosition().x, groundPart.getPosition().y);
        }

        sb.draw(ghost.getTexture(), ghost.getPosition().x, ghost.getPosition().y);

        boolean flip = false;

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            carlos.move(Input.Keys.RIGHT);
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            carlos.move(Input.Keys.LEFT);
            flip = true;
        }

        sb.draw(carlos.getTexture(),
                flip ? carlos.getPosition().x + carlos.getTexture().getRegionWidth() : carlos.getPosition().x, carlos.getPosition().y,
                flip ? -carlos.getTexture().getRegionWidth() : carlos.getTexture().getRegionWidth(), carlos.getTexture().getRegionHeight());

        sb.end();
    }

    @Override
    public void dispose() {

    }
}
