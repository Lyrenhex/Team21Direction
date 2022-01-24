package com.team21direction.pirategame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.team21direction.pirategame.screens.MainScreen;
import com.team21direction.pirategame.screens.TitleScreen;

public class PirateGame extends Game implements ApplicationListener {
	/* Constants */
	public final static String TITLE = "Pirate Game!";
	public final static int WORLD_WIDTH = 800;
	public final static int WORLD_HEIGHT = 480;
	public final static int SHIPS_PER_COLLEGE = 5;

	/* Screens */
	public TitleScreen titleScreen;
	public MainScreen mainScreen;

	SpriteBatch batch;
    Texture img;
    OrthographicCamera camera;

	/**
	 * create() is called on game start. Load the game screens and display the title screen first.
	 */
	@Override
	public void create () {
		titleScreen = new TitleScreen(this);
		mainScreen = new MainScreen(this);
		batch = new SpriteBatch();
        img = new Texture("rsH6n.jpg");
        camera = new OrthographicCamera(1280, 720);
        camera.update();

		this.setScreen(titleScreen);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
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
	
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		float x = Gdx.input.getDeltaX();
		float y = Gdx.input.getDeltaY();

		camera.translate(-x,y);
		return true;
	}
}
