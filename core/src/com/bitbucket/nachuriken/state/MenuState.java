package com.bitbucket.nachuriken.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Ain't Nobody Got Time for That
 */
public class MenuState extends AbstractState {

    private final BitmapFont start;

    public MenuState(GameStateManager gsm) {
        super(gsm);

        start = new BitmapFont();
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();

        start.draw(sb, "Press any key to continue.", 25, 100);

        sb.end();
    }

    @Override
    public void dispose() {
        start.dispose();
    }
}
