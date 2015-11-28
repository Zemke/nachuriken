package com.bitbucket.nachuriken.state;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bitbucket.nachuriken.sprite.Carlos;

/**
 * Ain't Nobody Got Time for That
 */
public class PlayState extends AbstractState {


    private final Carlos carlos;
    private final Texture ground;

    public PlayState(GameStateManager gsm) {
        super(gsm);

        ground = new Texture("ground.png");
        carlos = new Carlos(50, 112);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

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
