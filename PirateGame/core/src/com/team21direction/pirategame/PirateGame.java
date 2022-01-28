package com.team21direction.pirategame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.team21direction.pirategame.screens.MainScreen;
import com.team21direction.pirategame.screens.TitleScreen;

public class PirateGame extends Game implements ApplicationListener {
	/* Constants */
	public final static String TITLE = "Pirate Game!";
	public final static int WORLD_WIDTH = 2500;
	public final static int WORLD_HEIGHT = 2500;
	public final static int SHIPS_PER_COLLEGE = 5;

	/* Screens */
	public TitleScreen titleScreen;
	public MainScreen mainScreen;

	/**
	 * create() is called on game start. Load the game screens and display the title screen first.
	 */
	@Override
	public void create () {
		titleScreen = new TitleScreen(this);
		mainScreen = new MainScreen(this);

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
