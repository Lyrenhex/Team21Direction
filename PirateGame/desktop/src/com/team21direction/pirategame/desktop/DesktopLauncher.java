package com.team21direction.pirategame.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.team21direction.pirategame.PirateGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle(PirateGame.TITLE);
		config.setForegroundFPS(60);
		new Lwjgl3Application(new PirateGame(), config);
	}
}
