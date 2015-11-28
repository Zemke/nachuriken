package com.bitbucket.nachuriken.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bitbucket.nachuriken.sprite.Carlos;

/**
 * Ain't Nobody Got Time for That
 */
public class PlayState extends AbstractState {

    public static final int GROUND_HEIGHT = 112;

    private final Carlos carlos;
    private final Texture ground;

    public PlayState(GameStateManager gsm) {
        super(gsm);

        ground = new Texture("ground.png");
        carlos = new Carlos(50, GROUND_HEIGHT);
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

        carlos.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();

        sb.draw(ground, 0, 0);
        sb.draw(carlos.getTexture(), carlos.getPosition().x, carlos.getPosition().y);

        sb.end();
    }

    @Override
    public void dispose() {

    }
}
