package com.bitbucket.nachuriken.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bitbucket.nachuriken.Nachuriken;
import com.bitbucket.nachuriken.sprite.Carlos;
import com.bitbucket.nachuriken.sprite.Ghost;
import com.bitbucket.nachuriken.sprite.ground.Ground;

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
        carlos = new Carlos(200, Ground.HEIGHT);
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
        cam.position.x = carlos.getPosition().x + 80;

        carlos.update(dt);
        ghost.update(dt);

        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();

        for (int i = 0; i < ground.getGroundParts().size; i++) {
            sb.draw(ground.getGroundParts().get(i).getTexture(),
                    ground.getGroundParts().get(i).getX(), ground.getGroundParts().get(i).getY());
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
