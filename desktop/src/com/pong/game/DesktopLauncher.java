package com.pong.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;


// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		// Instantiating Singleton class (PongGame) with variable pongGame
		PongGame pongGame = PongGame.getInstance();
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle(PongGame.APP_TITLE + " v" + PongGame.APP_VERSION);
		config.setWindowedMode(PongGame.WIDTH, PongGame.HEIGHT);
		config.setForegroundFPS(PongGame.FPS);

		// Start new pong game
		new Lwjgl3Application(pongGame, config);
	}
}