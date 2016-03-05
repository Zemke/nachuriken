package com.bitbucket.nachuriken.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bitbucket.nachuriken.Highscore;
import com.bitbucket.nachuriken.Nachuriken;
import com.bitbucket.nachuriken.Util;
import com.bitbucket.nachuriken.sprite.Carlos;
import com.bitbucket.nachuriken.sprite.Ghost;
import com.bitbucket.nachuriken.sprite.ground.Ground;
import com.bitbucket.nachuriken.sprite.ground.GroundPart;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Ain't Nobody Got Time for That
 */
public class PlayState extends AbstractState {

    private final Carlos carlos;
    private final Ghost ghost;
    private final List<Nacho> nachosFlyingAround;
    private final Highscore highscore;
    private Ground ground;
    private boolean throwNewNacho;

    public PlayState(GameStateManager gsm) {
        super(gsm);

        cam.setToOrtho(false, Nachuriken.WIDTH / 2, Nachuriken.HEIGHT / 2);
        ground = new Ground();
        carlos = new Carlos(Ground.WIDTH + (Ground.WIDTH / 2), Ground.HEIGHT);
        ghost = new Ghost(Ground.WIDTH * 2, Ground.HEIGHT);
        nachosFlyingAround = new ArrayList<Nacho>();
        highscore = new Highscore(carlos.getPosition().x);
    }

    @Override
    protected void handleInput() {
        if (carlos.isDieing()) {
            return;
        }

        if (Gdx.input.justTouched() || Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            carlos.jump();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            carlos.move(Input.Keys.RIGHT);
            carlos.setMoving(true);
            carlos.setFlipped(false);
            carlos.setCrouched(false);
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            carlos.move(Input.Keys.LEFT);
            carlos.setMoving(true);
            carlos.setFlipped(true);
            carlos.setCrouched(false);
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            carlos.setCrouched(true);
        } else {
            carlos.setMoving(false);
            carlos.setCrouched(false);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            // Throw a nacho.
            throwNewNacho = true;
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        updateGround();
        cam.position.x = carlos.getPosition().x + 80;

        carlos.update(dt);
        ghost.update(dt);
        highscore.update(carlos.getPosition().x);

        for (Nacho nacho : nachosFlyingAround) {
            nacho.update(dt);
        }

        if (carlos.getBounds().overlaps(ghost.getBounds())) {
            highscore.startOver();
            carlos.dieHard();
        }

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
        }

        float startOfLast = groundParts.getLast().getPosition().x;

        if (startOfLast - Ground.WIDTH < carlos.getPosition().x) {
            GroundPart newLast = groundParts.pollFirst();
            newLast.getPosition().x = startOfLast + Ground.WIDTH;
            groundParts.addLast(newLast);
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

        if (carlos.isCrouched()) {
            sb.draw(carlos.getCrouchedCarlos(), carlos.getPosition().x, carlos.getPosition().y);
        } else if (carlos.isInTheAir()) {
            sb.draw(carlos.getJumpingCarlos(),
                    Util.flipX(carlos.isFlipped(), carlos.getPosition().x, carlos.getJumpingCarlos().getWidth()), carlos.getPosition().y,
                    Util.flipY(carlos.isFlipped(), carlos.getJumpingCarlos().getWidth()), carlos.getJumpingCarlos().getHeight());
        } else {
            sb.draw(carlos.getTexture(),
                    Util.flipX(carlos.isFlipped(), carlos.getPosition().x, carlos.getTexture().getRegionWidth()), carlos.getPosition().y,
                    Util.flipY(carlos.isFlipped(), carlos.getTexture().getRegionWidth()), carlos.getTexture().getRegionHeight());
        }

        if (throwNewNacho) {
            nachosFlyingAround.add(new Nacho((int) carlos.getPosition().x + 12,
                    (int) carlos.getPosition().y + 5, carlos.isFlipped()));
            throwNewNacho = false;
        }

        for (Nacho nacho : nachosFlyingAround) {
            sb.draw(nacho.getTexture(), nacho.getPosition().x, nacho.getPosition().y);
        }

        sb.draw(ghost.getTexture(),
                Util.flipX(ghost.isFlipped(), ghost.getPosition().x, ghost.getTexture().getWidth()), ghost.getPosition().y,
                Util.flipY(ghost.isFlipped(), ghost.getTexture().getWidth()), ghost.getTexture().getHeight());

        highscore.getText().draw(sb, String.valueOf((int) highscore.getHighscore()), cam.position.x +  5 - cam.viewportWidth / 2, 15);

        sb.end();
    }

    @Override
    public void dispose() {

    }
}
