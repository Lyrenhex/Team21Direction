package com.team21direction.pirategame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.team21direction.pirategame.screens.TitleScreen;

public class PirateGame extends Game implements ApplicationListener {
	/* Constants */
	public final String TITLE = "Pirate Game!";
	public final int WORLD_WIDTH = 800;
	public final int WORLD_HEIGHT = 480;

	/* Screens */
	private TitleScreen titleScreen;

	@Override
	public void create () {
		titleScreen = new TitleScreen(this);

		this.setScreen(titleScreen);
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}
}
