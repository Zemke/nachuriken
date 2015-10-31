package com.bitbucket.nachuriken.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.bitbucket.nachuriken.GameScenes.HUD;
import com.bitbucket.nachuriken.Nachuriken;

/**
 * Created by martin on 31/10/15.
 */
public class GameScreen implements Screen {

    private Nachuriken game;

    private OrthographicCamera gameCam;
    private Viewport viewport;

    private HUD hud;
    public GameScreen(Nachuriken game) {
        this.game = game;
        gameCam = new OrthographicCamera();
        viewport = new FitViewport(Nachuriken.WIDTH, Nachuriken.HEIGHT, gameCam);
        hud = new HUD(game.batch);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}