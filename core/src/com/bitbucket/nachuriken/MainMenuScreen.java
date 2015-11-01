package com.bitbucket.nachuriken;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Ain't Nobody Got Time For That
 */
public class MainMenuScreen extends ScreenAdapter {

    public static final String MAIN_MENU_SCREEN = "MAIN_MENU_SCREEN";
    final OurGame game;
    OrthographicCamera camera;

    public MainMenuScreen(final OurGame ourGame) {
        game = ourGame;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, OurGame.WIDTH, OurGame.HEIGHT);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "Welcome to Nachuriken!!! ", 100, 150);
        game.font.draw(game.batch, "Tap anywhere to begin!", 100, 100);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
    }
}
