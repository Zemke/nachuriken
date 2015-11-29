package com.bitbucket.nachuriken.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bitbucket.nachuriken.sprite.Carlos;
import com.bitbucket.nachuriken.sprite.ground.Ground;

/**
 * Ain't Nobody Got Time for That
 */
public class PlayState extends AbstractState {

    private final Carlos carlos;
    private Ground ground;

    public PlayState(GameStateManager gsm) {
        super(gsm);

        ground = new Ground();
        carlos = new Carlos(200, Ground.HEIGHT);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched() || Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            carlos.jump();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            carlos.move(Input.Keys.RIGHT);
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            carlos.move(Input.Keys.LEFT);
        }
    }

    @Override
    public void update(float dt) {
        handleInput();

        carlos.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();

        for (int i = 0; i < ground.getGroundParts().size; i++) {
            sb.draw(ground.getGroundParts().get(i).getTexture(),
                    ground.getGroundParts().get(i).getX(), ground.getGroundParts().get(i).getY());
        }

        sb.draw(carlos.getTexture(), carlos.getPosition().x, carlos.getPosition().y);

        sb.end();
    }

    @Override
    public void dispose() {

    }
}
