package com.bitbucket.nachuriken.GameScenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.bitbucket.nachuriken.Nachuriken;

/**
 * Created by martin on 31/10/15.
 */
public class HUD {
    public Stage stage;
    private Viewport viewport;

    //healthPoints
    private int hp;

    private Integer worldTimer;
    private float distance;
    private Integer timeCount;

    private Integer score;

    Label countDownLabel;
    Label scoreLabel;
    Label playerLabel;
    Label distanceLabel;

    public HUD(SpriteBatch batch) {
        worldTimer = 60;
        timeCount = 0;
        distance = 0;
        score = 0;

        viewport = new FitViewport(Nachuriken.WIDTH, Nachuriken.HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, batch);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        countDownLabel = new Label(String.format("%02d", worldTimer), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLabel = new Label(String.format("%06d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        playerLabel = new Label("Player", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        distanceLabel = new Label(String.format("%06f", distance), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(playerLabel).expandX().padTop(0);
        table.add(distanceLabel).expandX().padTop(0);
        table.add(countDownLabel).expandX().padTop(0);
        table.add(scoreLabel).expandX().padTop(0);

        stage.addActor(table);
    }
}