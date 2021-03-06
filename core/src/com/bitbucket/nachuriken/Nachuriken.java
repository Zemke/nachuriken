package com.bitbucket.nachuriken;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bitbucket.nachuriken.state.GameStateManager;
import com.bitbucket.nachuriken.state.MenuState;
import com.bitbucket.nachuriken.state.PlayState;

/**
 * Ain't Nobody Got Time for That
 */
public class Nachuriken extends ApplicationAdapter {

    public static final int WIDTH = 16 * 70;
    public static final int HEIGHT = 9 * 70;

    private GameStateManager gsm;
    private SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        gsm = new GameStateManager();
        Gdx.gl.glClearColor(178 / 255f, 166 / 255f, 155 / 255f, 1);
        gsm.push(new PlayState(gsm));
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
    }
}
