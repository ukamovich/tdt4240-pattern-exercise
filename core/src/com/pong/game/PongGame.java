package com.pong.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pong.game.states.GameStateManager;
import com.pong.game.states.MenuState;

public class PongGame extends Game {

	// Static member holds only one instance of the PongGame class (Singleton class)
	private static PongGame pg_instance = null;

	// Desktop Application Vars
	public static String APP_TITLE = "Pong GDX";
	public static double APP_VERSION = 0.1;
	public static int WIDTH = 720;
	public static int HEIGHT = 420;
	public static int FPS = 60;

	private GameStateManager gsm;
	private SpriteBatch batch;

	// Private constructor that prevents the instantiation of the PongGame class from outside
	public PongGame() {}

	// Static method that provides users with instances
	public static  PongGame getInstance() {
		if (pg_instance == null) {
			pg_instance = new PongGame();
		}
		return pg_instance;
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		gsm.push(new MenuState(gsm));
//		gsm.push(new PlayState(gsm));
	}

	@Override
	public void render () {
//		Gdx.gl.glClearColor(.25f, .25f, .25f,  1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);


		// Exit game by pressing Escape button
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
