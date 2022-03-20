package com.pong.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pong.game.PongGame;

public class MenuState extends State {

    private final Texture playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        playBtn = new Texture("menu/playbtn.png");
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        Gdx.gl.glClearColor(.116f,.179f,.246f,.5f);
        spriteBatch.draw(playBtn, (float) (PongGame.WIDTH / 2) - (float) playBtn.getWidth() / 2, (float) PongGame.HEIGHT / 2);
        spriteBatch.end();

        if (Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
            dispose();
        }
    }

    @Override
    public void handleInput() {
    }

    @Override
    public void update(float dt) {
    }

    @Override
    public void dispose() {
        playBtn.dispose();
    }
}