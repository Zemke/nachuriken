package com.bitbucket.nachuriken;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bitbucket.nachuriken.GameScenes.HUD;
import com.bitbucket.nachuriken.Screens.GameScreen;

public class Nachuriken extends Game {
	//public cause only use one spritebach memory intesive!!
	public SpriteBatch batch;

	public static final int WIDTH = 620;
	public static final int HEIGHT = 500;


	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
}